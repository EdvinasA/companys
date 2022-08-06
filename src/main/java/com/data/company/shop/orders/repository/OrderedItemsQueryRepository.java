package com.data.company.shop.orders.repository;

import com.data.company.shop.orders.model.OrderedItems;
import com.data.company.shop.orders.repository.converters.OrderedItemsConverter;
import com.data.company.shop.orders.repository.jpa.OrderedItemsJpaRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class OrderedItemsQueryRepository {

  private final OrderedItemsJpaRepository jpaRepository;
  private final OrderedItemsConverter converter;

  public List<OrderedItems> findOrderedItemsByOrderId(UUID orderId) {
    return jpaRepository.findByOrderId(orderId)
        .stream()
        .map(converter::convertFromEntity)
        .collect(Collectors.toList());
  }
}
