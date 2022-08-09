package com.data.company.shop.orders.controller;

import com.data.company.shop.orders.model.OrderedItems;
import com.data.company.shop.orders.service.OrderedItemsQueryService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordered-items/{userId}")
@AllArgsConstructor
@Slf4j
public class OrderedItemsController {

  private final OrderedItemsQueryService queryService;

  @GetMapping("{orderId}")
  public ResponseEntity<List<OrderedItems>> getListOfOrdersForOrder(@PathVariable UUID userId, @PathVariable UUID orderId) {
    log.info("Received request for retrieving order items: [User ID: {}, Order ID: {}]", userId, orderId);

    List<OrderedItems> result = queryService.findAllByOrderId(orderId);
    log.info("Retrieved a list of ordered items: [Size: {}]", result.size());

    return ResponseEntity.ok(result);
  }
}
