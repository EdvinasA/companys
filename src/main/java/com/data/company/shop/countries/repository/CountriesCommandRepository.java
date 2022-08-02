package com.data.company.shop.countries.repository;

import com.data.company.shop.countries.repository.entities.CountryEntity;
import com.data.company.shop.countries.repository.jpa.CountriesJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class CountriesCommandRepository {

  private final CountriesJpaRepository jpaRepository;

  @Transactional
  public void create(String name) {
    CountryEntity entity = new CountryEntity()
        .setName(name);

    jpaRepository.save(entity);
  }
}
