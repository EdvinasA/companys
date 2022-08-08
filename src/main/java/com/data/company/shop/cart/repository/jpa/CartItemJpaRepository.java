package com.data.company.shop.cart.repository.jpa;

import com.data.company.shop.cart.repository.entity.CartEntity;
import com.data.company.shop.cart.repository.entity.CartItemEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemJpaRepository extends JpaRepository<CartItemEntity, Long> {

  List<CartItemEntity> findByCart(CartEntity cartEntity);

  void deleteAllByCart(CartEntity cartEntity);
}
