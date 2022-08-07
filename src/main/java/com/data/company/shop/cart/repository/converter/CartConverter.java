package com.data.company.shop.cart.repository.converter;

import com.data.company.shop.cart.model.Cart;
import com.data.company.shop.cart.repository.entity.CartEntity;
import org.springframework.stereotype.Component;

@Component
public class CartConverter {

  public Cart convertFromEntity(CartEntity entity) {
    Cart cart = new Cart();
    cart.setId(entity.getId());
    cart.setPurchaseDate(entity.getPurchaseDate());
    cart.setUserId(entity.getUserId());
    return cart;
  }

  public CartEntity convertToEntity(Cart cart) {
    CartEntity entity = new CartEntity();
    entity.setId(cart.getId());
    entity.setPurchaseDate(cart.getPurchaseDate());
    entity.setUserId(cart.getUserId());
    return entity;
  }
}
