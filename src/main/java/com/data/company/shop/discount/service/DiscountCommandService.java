package com.data.company.shop.discount.service;

import com.data.company.shop.discount.model.Discount;
import com.data.company.shop.discount.repository.DiscountCommandRepository;
import com.data.company.shop.discount.repository.DiscountQueryRepository;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DiscountCommandService {

  private final DiscountCommandRepository commandRepository;
  private final DiscountQueryRepository queryRepository;

  public void createDiscount(Discount input) {
    input.setId(UUID.randomUUID());

    commandRepository.create(input);
  }
}
