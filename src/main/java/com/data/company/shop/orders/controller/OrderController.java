package com.data.company.shop.orders.controller;

import com.data.company.shop.orders.model.Order;
import com.data.company.shop.orders.model.OrderInput;
import com.data.company.shop.orders.service.OrderCommandService;
import com.data.company.shop.orders.service.OrderQueryService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order/{userId}")
@AllArgsConstructor
@Slf4j
public class OrderController {

  private final OrderQueryService queryService;
  private final OrderCommandService commandService;

  @PostMapping
  public ResponseEntity<Void> createOrder(@RequestBody OrderInput input, @PathVariable UUID userId) {
    input.setUserId(userId);

    log.info("Received input for creating order");
    commandService.createOrder(input);

    log.info("Created order");
    return ResponseEntity.ok(null);
  }

  @GetMapping
  public ResponseEntity<List<Order>> findAllOrdersByUserId(@PathVariable UUID userId) {
    log.info("Received request for list of orders for user with id: {}", userId);

    List<Order> result = queryService.findAllByUserId(userId);
    log.info("Retrieved list of orders [Size: {}]", result.size());

    return ResponseEntity.ok(result);
  }
}
