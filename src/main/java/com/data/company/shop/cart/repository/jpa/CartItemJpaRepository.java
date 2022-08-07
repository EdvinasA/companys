package com.data.company.shop.cart.repository.jpa;

import com.data.company.shop.cart.repository.entity.CartEntity;
import com.data.company.shop.cart.repository.entity.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemJpaRepository extends JpaRepository<CartItemEntity, Long> {

  void deleteAllByCart(CartEntity cartEntity);
}
