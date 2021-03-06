package com.data.company.shop.cart.controller;

import com.data.company.shop.cart.model.Cart;
import com.data.company.shop.cart.service.CartCommandService;
import com.data.company.shop.cart.service.CartQueryService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop/cart")
@AllArgsConstructor
@Slf4j
public class CartController {

  private final CartCommandService commandService;
  private final CartQueryService queryService;

  @PostMapping
  public void createCart(Cart cart) {
    log.info("Creating cart for user with id: {}", cart.getUserId());
    commandService.createCart(cart);
  }

  @GetMapping("{userId}")
  public ResponseEntity<List<Cart>> getCartByUserId(@PathVariable UUID userId) {
    log.info("Retrieving cart items for userId={}", userId);

    List<Cart> cart = queryService.findByUserId(userId);
    log.info("Retrieved car items. Size: {}", cart.size());

    return ResponseEntity.ok(cart);
  }
}
