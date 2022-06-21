package com.data.company.shop.laptops.repository;

import com.data.company.shop.laptops.model.Laptop;
import com.data.company.shop.laptops.repository.converter.LaptopConverter;
import com.data.company.shop.laptops.repository.jpa.LaptopRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class LaptopQueryRepository {

  private final LaptopConverter converter;
  private final LaptopRepository jpaRepository;

  public Page<Laptop> findAll(Pageable pageable) {
    return jpaRepository.findAll(pageable)
        .map(converter::convertFromEntity);
  }
}
