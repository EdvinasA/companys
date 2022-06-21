package com.data.company.shop.laptops.repository;

import com.data.company.shop.laptops.model.Laptop;
import com.data.company.shop.laptops.repository.converter.LaptopConverter;
import com.data.company.shop.laptops.repository.entity.LaptopEntity;
import com.data.company.shop.laptops.repository.jpa.LaptopRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class LaptopCommandRepository {

  private final LaptopConverter converter;
  private final LaptopRepository jpaRepository;

  @Transactional
  public void save(Laptop input) {
    LaptopEntity entity = converter.convertToEntity(input);

    jpaRepository.save(entity);
  }
}
