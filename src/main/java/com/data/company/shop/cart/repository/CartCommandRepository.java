package com.data.company.shop.cart.repository;

import com.data.company.shop.cart.model.Cart;
import com.data.company.shop.cart.repository.converter.CartConverter;
import com.data.company.shop.cart.repository.entity.CartEntity;
import com.data.company.shop.cart.repository.jpa.CartJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class CartCommandRepository {

  private final CartJpaRepository jpaRepository;
  private final CartConverter converter;

  @Transactional
  public void create(Cart cart) {
    CartEntity entity = converter.convertToEntity(cart);

    jpaRepository.save(entity);
  }

  public void update(Cart cart) {
    CartEntity entity = converter.convertToEntity(cart);

    jpaRepository.save(entity);
  }

}
