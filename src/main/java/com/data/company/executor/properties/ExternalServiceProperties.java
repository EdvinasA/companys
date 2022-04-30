package com.data.company.executor.properties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExternalServiceProperties {

  private String baseUrl;
  private String basicAuthenticationUsername;
  private String basicAuthenticationPassword;
  private ResilienceProperties resilience;
}
