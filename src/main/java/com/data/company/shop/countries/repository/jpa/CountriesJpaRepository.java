package com.data.company.shop.countries.repository.jpa;

import com.data.company.shop.countries.repository.entities.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountriesJpaRepository extends JpaRepository<CountryEntity, Long> {}
