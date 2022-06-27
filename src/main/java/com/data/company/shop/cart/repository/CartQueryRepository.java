package com.data.company.shop.cart.repository;

import com.data.company.shop.cart.model.Cart;
import com.data.company.shop.cart.repository.converter.CartConverter;
import com.data.company.shop.cart.repository.jpa.CartJpaRepository;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CartQueryRepository {

  private final CartJpaRepository jpaRepository;
  private final CartConverter converter;

  public Cart findByUserId(UUID userId) {
    return jpaRepository.findByUserId(userId)
        .map(converter::convertFromEntity)
        .orElse(new Cart());
  }

}
