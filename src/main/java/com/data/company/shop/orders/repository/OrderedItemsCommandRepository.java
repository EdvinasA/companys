package com.data.company.shop.orders.repository;

import com.data.company.shop.orders.model.OrderedItems;
import com.data.company.shop.orders.repository.converters.OrderedItemsConverter;
import com.data.company.shop.orders.repository.entities.OrderedItemsEntity;
import com.data.company.shop.orders.repository.jpa.OrderedItemsJpaRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class OrderedItemsCommandRepository {

  private final OrderedItemsJpaRepository jpaRepository;
  private final OrderedItemsConverter converter;

  @Transactional
  public void create(List<OrderedItems> items) {
    List<OrderedItemsEntity> entities = items.stream()
        .map(converter::convertToEntity)
        .collect(Collectors.toList());

    jpaRepository.saveAll(entities);
  }
}
