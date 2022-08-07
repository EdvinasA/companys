package com.data.company.shop.cart.service;

import com.data.company.shop.cart.model.Cart;
import com.data.company.shop.cart.model.CartStatus;
import com.data.company.shop.cart.repository.CartCommandRepository;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CartCommandService {

  private final CartCommandRepository commandRepository;
  private final CartQueryService queryService;
  private final CartItemCommandService cartItemCommandService;

  public void createCart(UUID userId) {
    commandRepository.create(new Cart()
        .setUserId(userId)
        .setId(UUID.randomUUID())
        .setStatus(CartStatus.FILLING));
  }

  @Transactional
  public void updateCart(Cart cart) {
    cartItemCommandService.deleteAllCartItems(cart.getId());
    commandRepository.update(cart);
  }

  public void moveCartToOrder(UUID userId) {
    Cart cart = queryService.findByUserId(userId);
    cart.setStatus(CartStatus.MOVED_TO_ORDER);
    commandRepository.update(cart);

    // After old cart moved to different status, create new cart for user
    createCart(userId);
  }
}
