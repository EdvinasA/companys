package com.data.company.executor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import reactor.core.publisher.Mono;

@Slf4j
public class LoggingFunctions {

	public static ExchangeFilterFunction logRequest() {
		return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
			log.info("Calling endpoint {}", clientRequest.url());

			return Mono.just(clientRequest);
		});
	}
}
