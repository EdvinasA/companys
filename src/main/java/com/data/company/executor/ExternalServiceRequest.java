package com.data.company.executor;

import java.util.Collections;
import java.util.Optional;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

@Slf4j
public abstract class ExternalServiceRequest<I, O> {

  public abstract HttpMethod getHttpMethod();

  public abstract String getEndpoint();

  public abstract String getOperationName();

  public abstract Optional<O> fallbackResponse();

  public Optional<I> getRequestBody() {
    return Optional.empty();
  }

  public Consumer<O> doOnSuccess() {
    return (item) -> {
    };
  }

  public MultiValueMap<String, String> getQueryParameters() {
    return new LinkedMultiValueMap<>();
  }

  public void putParameterIfNotBlank(String parameterName, String value,
      MultiValueMap<String, String> parameters) {
    if (StringUtils.isNotBlank(value)) {
      parameters.put(parameterName, Collections.singletonList(value));
    }
  }

  public Object[] getPathParameters() {
    return new Object[]{};
  }

  public abstract ParameterizedTypeReference<O> getResponseBody();

  public Mono<O> getBody(ClientResponse clientResponse) {
    return clientResponse.body(BodyExtractors.toMono(getResponseBody()));
  }

  public O getFallbackResponse() {
    Optional<O> fallbackResponse = fallbackResponse();
    if (fallbackResponse.isEmpty()) {
      log.error("No response {}", getOperationName());

      return null;
    }

    log.warn("Response {}", getOperationName());
    return fallbackResponse.get();
  }
}
