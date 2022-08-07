package com.data.company.shop.cart.service;

import com.data.company.shop.cart.repository.CartItemCommandRepository;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CartItemCommandService {

  private final CartItemCommandRepository commandRepository;

  public void deleteAllCartItems(UUID cartId) {
    log.info("Removing all items from cart to update with new ones");
    commandRepository.deleteAllCartItems(cartId);
  }
}
