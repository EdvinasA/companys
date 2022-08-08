package com.data.company.shop.cart.repository.converter;

import com.data.company.shop.cart.model.Cart;
import com.data.company.shop.cart.model.CartItem;
import com.data.company.shop.cart.repository.entity.CartEntity;
import com.data.company.shop.cart.repository.entity.CartItemEntity;
import java.util.ArrayList;
import java.util.List;
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
        .setStatus(entity.getStatus())
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
        .setStatus(cart.getStatus())
        .setCartItems(setIfNotNull(cart.getCartItems()));
  }

  private List<CartItemEntity> setIfNotNull(List<CartItem> cartItem) {
    if (cartItem != null) {
      return cartItem
          .stream()
          .map(cartItemConverter::convertToEntity)
          .collect(Collectors.toList());
    }
    return new ArrayList<>();
  }
}
