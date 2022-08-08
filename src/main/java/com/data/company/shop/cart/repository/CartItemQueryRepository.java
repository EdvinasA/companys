package com.data.company.shop.cart.repository;

import com.data.company.shop.cart.model.Cart;
import com.data.company.shop.cart.model.CartItem;
import com.data.company.shop.cart.repository.converter.CartConverter;
import com.data.company.shop.cart.repository.converter.CartItemConverter;
import com.data.company.shop.cart.repository.jpa.CartItemJpaRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CartItemQueryRepository {

  private final CartConverter cartConverter;
  private final CartItemJpaRepository jpaRepository;
  private final CartItemConverter cartItemConverter;

  public List<CartItem> findCartItemsForCart(Cart cart) {
    return jpaRepository.findByCart(cartConverter.convertToEntity(cart))
        .stream()
        .map(cartItemConverter::convertFromEntity)
        .collect(Collectors.toList());
  }
}
