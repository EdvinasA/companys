package com.data.company.executor;

import com.data.company.executor.exception.ExternalServiceSystemException;
import com.data.company.executor.properties.ExternalServiceProperties;
import com.data.company.utils.Base64Utils;
import com.data.company.utils.JsonUtils;
import com.data.company.utils.ReactiveUtils;
import java.util.Optional;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ReactiveHttpOutputMessage;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Slf4j
public class ExternalServiceWebClient {

  static {
    ReactiveUtils.registerScheduleHook();
  }

  private final WebClient webClient;

  @Autowired
  public ExternalServiceWebClient(
      ExternalServiceProperties properties) {
    webClient = initWebClient(properties);
  }

  public <I, O> Mono<ExternalServiceResponse<O>> buildPublisher(
      ExternalServiceRequest<I, O> request) {
    MultiValueMap<String, String> queryParameters = request.getQueryParameters();

    return webClient
        .method(request.getHttpMethod())
        .uri(builder -> builder
            .path(request.getEndpoint())
            .queryParams(queryParameters)
            .build(request.getPathParameters()))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .body(getBodyInserter(request))
        .exchangeToMono(bodyToMono(request));
  }

  private <I, O> Function<ClientResponse, Mono<ExternalServiceResponse<O>>> bodyToMono(
      ExternalServiceRequest<I, O> request) {
    return (response) -> {
      int statusCode = response.rawStatusCode();

      if (response.statusCode().is4xxClientError()) {
        log.warn("Error code: {}", statusCode);
        return response.bodyToMono(ExternalServiceError.class)
            .map(errorBody -> {
              log.warn("Error: {}", errorBody);
              return ExternalServiceResponse.of(request.getFallbackResponse(), errorBody);
            });
      }
      if (response.statusCode().is5xxServerError()) {
        log.error("Status code: {}", statusCode);
        response.bodyToMono(String.class)
            .flatMap(errorBody -> {
              log.error("Error: {}", errorBody);
              return Mono.error(new ExternalServiceSystemException());
            });
      }

      return request.getBody(response)
          .map(body -> ExternalServiceResponse.of(body, null));
    };
  }

  private <I, O> BodyInserter<String, ReactiveHttpOutputMessage> getBodyInserter(
      ExternalServiceRequest<I, O> request) {
    Optional<I> optionalBody = request.getRequestBody();
    if (optionalBody.isEmpty()) {
      return BodyInserters.empty();
    }

    return BodyInserters.fromValue(JsonUtils.toJson(optionalBody.get()));
  }

  private WebClient initWebClient(ExternalServiceProperties properties) {
    return WebClient.builder()
        .baseUrl(properties.getBaseUrl())
        .clientConnector(new ReactorClientHttpConnector(
            HttpClient.create().wiretap(true)
        ))
        .defaultHeaders(httpHeaders -> addHeaders(httpHeaders, properties))
        .filter(LoggingFunctions.logRequest())
        .filter(new MdcDecoratorFilter())
        .build();
  }

  private void addHeaders(HttpHeaders httpHeaders, ExternalServiceProperties properties) {
    if (StringUtils.isNotBlank(properties.getBasicAuthenticationUsername())) {
      httpHeaders.add(HttpHeaders.AUTHORIZATION, getBasicAuthorizationHeader(properties));
    }
  }

  private String getBasicAuthorizationHeader(ExternalServiceProperties properties) {
    String credentials = String.format("%s:%s",
        properties.getBasicAuthenticationUsername(),
        properties.getBasicAuthenticationPassword());

    String encodeCredentials = Base64Utils.encodeToString(credentials);
    return String.format("Basic %s", encodeCredentials);
  }
}
