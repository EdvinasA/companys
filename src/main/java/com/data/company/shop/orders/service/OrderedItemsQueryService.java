package com.data.company.shop.orders.service;

import com.data.company.shop.orders.model.OrderedItems;
import com.data.company.shop.orders.repository.OrderedItemsQueryRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderedItemsQueryService {

  private final OrderedItemsQueryRepository queryRepository;

  public List<OrderedItems> findAllByOrderId(UUID orderId) {
    return queryRepository.findOrderedItemsByOrderId(orderId);
  }
}
