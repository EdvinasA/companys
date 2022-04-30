package com.data.company.executor.exception;

import com.data.company.executor.ExternalServiceError;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ExternalServiceClientException extends RuntimeException {

  private ExternalServiceError errorMessage;

  public ExternalServiceClientException(ExternalServiceError errorMessage) {
    super(errorMessage.getMessage());
    this.errorMessage = errorMessage;
  }
}
