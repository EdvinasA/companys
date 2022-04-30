package com.data.company.executor.properties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResilienceProperties {

  private int timeoutInSeconds;
  private int retryDelayInSeconds;
  private int numberOfRetries;

  private CircuitBreakerProperties circuitBreaker;
}
