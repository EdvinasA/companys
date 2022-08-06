package com.data.company.shop.orders.service;

import com.data.company.shop.orders.model.OrderedItems;
import com.data.company.shop.orders.repository.OrderedItemsCommandRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderedItemsCommandService {

  private final OrderedItemsCommandRepository commandRepository;

  public void createOrderItems(List<OrderedItems> items, UUID orderId) {
    if (!items.isEmpty()) {
      List<OrderedItems> itemsUpdatedWithOrderId = items
          .stream()
          .map(item -> item.setOrderId(orderId))
          .collect(Collectors.toList());

      commandRepository.create(itemsUpdatedWithOrderId);
    }
  }
}
