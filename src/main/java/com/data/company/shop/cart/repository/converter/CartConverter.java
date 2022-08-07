package com.data.company.shop.cart.repository.converter;

import com.data.company.shop.cart.model.Cart;
import com.data.company.shop.cart.repository.entity.CartEntity;
import org.springframework.stereotype.Component;

@Component
public class CartConverter {

  public Cart convertFromEntity(CartEntity entity) {
    return new Cart()
        .setId(entity.getId())
        .setPurchaseDate(entity.getPurchaseDate())
        .setUserId(entity.getUserId());
  }

  public CartEntity convertToEntity(Cart cart) {
    return new CartEntity()
        .setId(cart.getId())
        .setPurchaseDate(cart.getPurchaseDate())
        .setUserId(cart.getUserId());
  }
}
