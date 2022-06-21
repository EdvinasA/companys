package com.data.company.shop.products.service;

import com.data.company.shop.products.model.Product;
import com.data.company.shop.products.repository.ProductQueryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductQueryService {

  private final ProductQueryRepository queryRepository;

  public Page<Product> findAllProducts(Pageable pageable) {
    return queryRepository.findAllProducts(pageable);
  }
}
