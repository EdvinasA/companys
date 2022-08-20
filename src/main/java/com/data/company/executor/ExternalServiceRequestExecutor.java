package com.data.company.executor;

import com.data.company.executor.exception.ExternalServiceClientException;
import com.data.company.executor.properties.ResilienceProperties;
import com.data.company.utils.ReactiveUtils;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.reactor.circuitbreaker.operator.CircuitBreakerOperator;
import java.time.Duration;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpMethod;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

@AllArgsConstructor
@Slf4j
public class ExternalServiceRequestExecutor {

	private final ExternalServiceWebClient externalServiceWebClient;
	private final ResilienceProperties resilienceProperties;
	private final CircuitBreaker externalServiceCircuitBreaker;

	public <I, O> O executeBlocking(ExternalServiceRequest<I, O> request) {
		ExternalServiceResponse<O> response = executeForServiceResponse(request).block();

		if (Objects.isNull(response)) {
			return null;
		}

		ExternalServiceError error = response.getError();
		if (Objects.nonNull(error)) {
			ExternalServiceError errorMessage = new ExternalServiceError(error.getCode(),
					error.getMessage());
			throw new ExternalServiceClientException(errorMessage);
		}

		return response.getResponse();
	}

	private <I, O> Mono<ExternalServiceResponse<O>> executeForServiceResponse(
			ExternalServiceRequest<I, O> request) {
		log.info("Preparing {}", request.getOperationName());

		var mdcContextMap = MDC.getCopyOfContextMap();

		return externalServiceWebClient.buildPublisher(request)
				.transformDeferred(CircuitBreakerOperator.of(externalServiceCircuitBreaker))
				.doOnEach(ReactiveUtils.consumeOnNext(result -> {
					log.info("Executed: {}", request.getOperationName());
					log.info("Response: {}", result);

					request.doOnSuccess().accept(result.getResponse());
				}))
				.doOnEach(ReactiveUtils.consumeOnError(error -> {
					if (Objects.nonNull(error)) {
						log.error("Error {}", error.getMessage());
					} else {
						log.error("Operation {}", request.getOperationName());
					}
				}))
				.timeout(getTimeoutConfiguration())
				.retryWhen(getRetryConfiguration(request))
				.onErrorResume(ReactiveUtils.withMdcContext(mdcContextMap,
						throwable -> Mono
								.just(ExternalServiceResponse.of(request.getFallbackResponse(), null))))
				.contextWrite(ReactiveUtils.put(mdcContextMap));
	}

	private <I, O> Retry getRetryConfiguration(ExternalServiceRequest<I, O> request) {
		if (request.getHttpMethod().equals(HttpMethod.GET)) {
			return getExponentialBackoffConfiguration();
		}

		return Retry.max(0L);
	}

	private Retry getExponentialBackoffConfiguration() {
		return Retry.backoff(resilienceProperties.getNumberOfRetries(),
				Duration.ofSeconds(resilienceProperties.getRetryDelayInSeconds()))
				.filter(throwable -> !(throwable instanceof ExternalServiceClientException));
	}

	private Duration getTimeoutConfiguration() {
		return Duration.ofSeconds(resilienceProperties.getTimeoutInSeconds());
	}

}
