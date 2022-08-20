package com.data.company.configuration;

import com.data.company.configuration.properties.CountriesProperties;
import com.data.company.executor.ExternalServiceRequestExecutor;
import com.data.company.executor.ExternalServiceWebClient;
import com.data.company.executor.exception.ExternalServiceSystemException;
import com.data.company.executor.properties.CircuitBreakerProperties;
import com.data.company.executor.properties.ResilienceProperties;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountriesExecutorConfiguration {

	@Bean
	@Qualifier("countriesCircuitBreaker")
	CircuitBreaker countriesCircuitBreaker(CountriesProperties countriesProperties) {
		CircuitBreakerRegistry registry = buildCircuitBreakerRegistry(countriesProperties.getResilience());

		return registry.circuitBreaker("countries");
	}

	@Bean
	@Qualifier("countriesRequestExecutor")
	ExternalServiceRequestExecutor countriesRequestExecutor(CountriesProperties countriesProperties,
			@Qualifier("countriesCircuitBreaker") CircuitBreaker circuitBreaker) {
		ExternalServiceWebClient externalServiceWebClient = new ExternalServiceWebClient(countriesProperties);

		return new ExternalServiceRequestExecutor(externalServiceWebClient, countriesProperties.getResilience(), circuitBreaker);
	}

	CircuitBreakerRegistry buildCircuitBreakerRegistry(ResilienceProperties resilienceProperties) {
		CircuitBreakerProperties circuitBreakerProperties = resilienceProperties.getCircuitBreaker();

		CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
				.failureRateThreshold(circuitBreakerProperties.getFailureRateThreshold())
				.waitDurationInOpenState(Duration.ofSeconds(circuitBreakerProperties.getSecondsInOpenState()))
				.permittedNumberOfCallsInHalfOpenState(circuitBreakerProperties.getPermittedNumberOfCallsInHalfOpenState())
				.slidingWindowSize(circuitBreakerProperties.getSlidingWindowSize())
				.recordExceptions(IOException.class, TimeoutException.class, ExternalServiceSystemException.class)
				.ignoreExceptions(ExternalServiceSystemException.class)
				.build();

		return CircuitBreakerRegistry.of(circuitBreakerConfig);
	}
}
