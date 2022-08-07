package com.data.company.shop.cart.repository.converter;

import com.data.company.shop.cart.model.Cart;
import com.data.company.shop.cart.repository.entity.CartEntity;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CartConverter {

  private final CartItemConverter cartItemConverter;

  public Cart convertFromEntity(CartEntity entity) {
    return new Cart()
        .setId(entity.getId())
        .setPurchaseDate(entity.getPurchaseDate())
        .setUserId(entity.getUserId())
        .setCartItems(entity.getCartItems()
            .stream()
            .map(cartItemConverter::convertFromEntity)
            .collect(Collectors.toList()));
  }

  public CartEntity convertToEntity(Cart cart) {
    return new CartEntity()
        .setId(cart.getId())
        .setPurchaseDate(cart.getPurchaseDate())
        .setUserId(cart.getUserId())
        .setCartItems(cart.getCartItems()
            .stream()
            .map(cartItemConverter::convertToEntity)
            .collect(Collectors.toList()));
  }
}
