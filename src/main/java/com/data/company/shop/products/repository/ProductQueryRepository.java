package com.data.company.shop.products.repository;

import com.data.company.shop.products.model.Product;
import com.data.company.shop.products.repository.converter.ProductConverter;
import com.data.company.shop.products.repository.jpa.ProductJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ProductQueryRepository {

  private final ProductJpaRepository jpaRepository;
  private final ProductConverter converter;

  public Page<Product> findAllProducts(Pageable pageable) {
    return jpaRepository.findAll(pageable)
        .map(converter::convertFromEntity);
  }
}
