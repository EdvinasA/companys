package com.data.company.shop.products.repository;

import com.data.company.exceptions.ProductNotFoundException;
import com.data.company.shop.products.model.Product;
import com.data.company.shop.products.repository.converter.ProductConverter;
import com.data.company.shop.products.repository.entity.ProductEntity;
import com.data.company.shop.products.repository.jpa.ProductJpaRepository;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class ProductCommandRepository {

  private final ProductJpaRepository jpaRepository;
  private final ProductConverter converter;

  @Transactional
  public void create(Product product) {
    ProductEntity entity = converter.convertToEntity(product);

    jpaRepository.save(entity);
  }

  @Transactional
  public void delete(UUID productId) {
    Optional<ProductEntity> optionalEntity = jpaRepository.findById(productId);
    ProductEntity entity = optionalEntity.orElseThrow(RuntimeException::new);

    jpaRepository.delete(entity);
  }

}
