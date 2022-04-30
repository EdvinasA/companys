package com.data.company.executor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExternalServiceResponse<O> {

  private O response;
  private ExternalServiceError error;

  public static <O> ExternalServiceResponse<O> of(O response, ExternalServiceError error) {
    ExternalServiceResponse<O> serviceResponse = new ExternalServiceResponse<>();

    serviceResponse.setResponse(response);
    serviceResponse.setError(error);

    return serviceResponse;
  }
}
