package com.data.company.shop.laptops.service;

import com.data.company.shop.laptops.model.Laptop;
import com.data.company.shop.laptops.repository.LaptopCommandRepository;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LaptopCommandService {

  private final LaptopCommandRepository commandRepository;

  public void createNew(Laptop laptop) {
    laptop.setId(UUID.randomUUID());

    commandRepository.save(laptop);
  }
}
