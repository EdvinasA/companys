package com.data.company.shop.countries.repository.converter;

import com.data.company.shop.countries.model.CountryName;
import com.data.company.shop.countries.repository.entities.CountryEntity;
import org.springframework.stereotype.Component;

@Component
public class CountryConverter {

  public CountryName convertFromEntity(CountryEntity entity) {
    return new CountryName()
        .setCommon(entity.getName());
  }
}
