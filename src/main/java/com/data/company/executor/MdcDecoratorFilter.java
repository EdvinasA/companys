package com.data.company.executor;

import java.util.Objects;
import org.slf4j.MDC;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import reactor.core.publisher.Mono;

public class MdcDecoratorFilter implements ExchangeFilterFunction {

  @Override
  public Mono<ClientResponse> filter(ClientRequest request, ExchangeFunction next) {
    var mdcContextMap = MDC.getCopyOfContextMap();

    return next.exchange(request)
        .doOnEach(value -> {
          if (Objects.nonNull(mdcContextMap)) {
            MDC.setContextMap(mdcContextMap);
          }
        });
  }
}
