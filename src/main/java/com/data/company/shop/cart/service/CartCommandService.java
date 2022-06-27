package com.data.company.shop.cart.service;

import com.data.company.shop.cart.model.Cart;
import com.data.company.shop.cart.repository.CartCommandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartCommandService {

  private final CartCommandRepository commandRepository;

  public void createCart(Cart cart) {
    commandRepository.create(cart);
  }
}
