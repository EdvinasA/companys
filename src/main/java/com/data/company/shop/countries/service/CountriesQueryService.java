package com.data.company.shop.countries.service;

import com.data.company.shop.countries.model.CountryName;
import com.data.company.shop.countries.repository.CountriesQueryRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountriesQueryService {

  private final CountriesQueryRepository queryRepository;

  public List<CountryName> getAll() {
    return queryRepository.getAll();
  }

}
