package com.data.company.configuration.properties;

import com.data.company.executor.properties.ExternalServiceProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "integrations.countries")
@Getter
@Setter
public class CountriesProperties extends ExternalServiceProperties {
}
