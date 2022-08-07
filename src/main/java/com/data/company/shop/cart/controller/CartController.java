package com.data.company.shop.cart.controller;

import com.data.company.shop.cart.model.Cart;
import com.data.company.shop.cart.service.CartCommandService;
import com.data.company.shop.cart.service.CartQueryService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart/{userId}")
@AllArgsConstructor
@Slf4j
public class CartController {

  private final CartCommandService commandService;
  private final CartQueryService queryService;

  @PutMapping
  public ResponseEntity<Void> updateCart(@RequestBody Cart cart, @PathVariable UUID userId) {
    cart.setUserId(userId);

    log.info("Received update cart request for user with id: {}", userId);

    commandService.updateCart(cart);
    log.info("Cart was updated");

    return ResponseEntity.ok(null);
  }

  @GetMapping
  public ResponseEntity<Cart> getCartByUserId(@PathVariable UUID userId) {
    log.info("Retrieving cart items for userId={}", userId);

    Cart cart = queryService.findByUserId(userId);
    log.info("Retrieved cart items. Size: {}", cart.getCartItems().size());

    return ResponseEntity.ok(cart);
  }
}
