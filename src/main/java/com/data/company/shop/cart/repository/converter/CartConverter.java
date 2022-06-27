package com.data.company.shop.cart.repository.converter;

import com.data.company.shop.cart.model.Cart;
import com.data.company.shop.cart.repository.entity.CartEntity;
import org.springframework.stereotype.Component;

@Component
public class CartConverter {

  public Cart convertFromEntity(CartEntity entity) {
    Cart cart = new Cart();
    cart.setId(entity.getId());
    cart.setProductName(entity.getProductName());
    cart.setProductCode(entity.getProductCode());
    cart.setPicture(entity.getPicture());
    cart.setInsurance(entity.isInsurance());
    cart.setWarranty(entity.isWarranty());
    cart.setPrice(entity.getPrice());
    cart.setPurchaseDate(entity.getPurchaseDate());
    return cart;
  }

  public CartEntity convertToEntity(Cart cart) {
    CartEntity entity = new CartEntity();
    entity.setId(cart.getId());
    entity.setProductName(cart.getProductName());
    entity.setProductCode(cart.getProductCode());
    entity.setPicture(cart.getPicture());
    entity.setInsurance(cart.isInsurance());
    entity.setWarranty(cart.isWarranty());
    entity.setPrice(cart.getPrice());
    entity.setPurchaseDate(cart.getPurchaseDate());
    return entity;
  }
}
