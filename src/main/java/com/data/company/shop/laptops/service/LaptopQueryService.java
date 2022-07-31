package com.data.company.shop.laptops.service;

import com.data.company.shop.laptops.model.Laptop;
import com.data.company.shop.laptops.repository.LaptopQueryRepository;
import com.data.company.shop.stripe.StripeService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LaptopQueryService {

  private final LaptopQueryRepository laptopQueryRepository;
  private final LaptopCommandService laptopCommandService;
  private final StripeService stripeService;

  public Page<Laptop> findAll(Pageable pageable) {
    laptopCommandService.updateLaptop();
    return laptopQueryRepository.findAll(pageable);
  }

  public Laptop findById(UUID id) throws NotFoundException {
    return laptopQueryRepository.findById(id);
  }

//  public
}
