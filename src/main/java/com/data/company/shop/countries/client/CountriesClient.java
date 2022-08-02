package com.data.company.shop.countries.client;

import com.data.company.executor.ExternalServiceRequestExecutor;
import com.data.company.shop.countries.client.requests.GetCountriesRequest;
import com.data.company.shop.countries.model.Country;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CountriesClient {

  private final ExternalServiceRequestExecutor executor;

  public List<Country> getCountries() {
    return executor.executeBlocking(new GetCountriesRequest());
  }
}
