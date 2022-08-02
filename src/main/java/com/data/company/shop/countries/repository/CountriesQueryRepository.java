package com.data.company.shop.countries.repository;

import com.data.company.shop.countries.model.CountryName;
import com.data.company.shop.countries.repository.converter.CountryConverter;
import com.data.company.shop.countries.repository.jpa.CountriesJpaRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CountriesQueryRepository {

  private final CountriesJpaRepository jpaRepository;
  private final CountryConverter converter;

  public List<CountryName> getAll() {
    return jpaRepository.findAll()
        .stream()
        .map(converter::convertFromEntity)
        .collect(Collectors.toList());
  }
}
