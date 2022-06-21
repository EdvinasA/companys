package com.data.company.shop.laptops.service;

import com.data.company.shop.laptops.model.Laptop;
import com.data.company.shop.laptops.repository.LaptopQueryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LaptopQueryService {

  private final LaptopQueryRepository laptopQueryRepository;

  public Page<Laptop> findAll(Pageable pageable) {
    return laptopQueryRepository.findAll(pageable);
  }
}
