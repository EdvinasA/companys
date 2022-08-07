package com.data.company.shop.cart.service;

import com.data.company.shop.cart.model.Cart;
import com.data.company.shop.cart.model.CartStatus;
import com.data.company.shop.cart.repository.CartCommandRepository;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartCommandService {

  private final CartCommandRepository commandRepository;
  private final CartQueryService queryService;

  public void createCart(UUID userId) {
    commandRepository.create(new Cart()
        .setUserId(userId)
        .setId(UUID.randomUUID())
        .setStatus(CartStatus.FILLING));
  }

  public void updateCart(UUID userId) {
    Cart cart = queryService.findByUserId(userId);
    cart.setStatus(CartStatus.MOVED_TO_ORDER);

    // After old cart moved to different status create new cart for user
    createCart(userId);
  }
}
