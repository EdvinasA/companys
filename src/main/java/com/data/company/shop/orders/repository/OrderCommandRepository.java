package com.data.company.shop.orders.repository;

import com.data.company.shop.orders.model.Order;
import com.data.company.shop.orders.repository.converters.OrderConverter;
import com.data.company.shop.orders.repository.entities.OrderEntity;
import com.data.company.shop.orders.repository.jpa.OrderJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class OrderCommandRepository {

  private final OrderJpaRepository jpaRepository;
  private final OrderConverter converter;

  @Transactional
  public void create(Order input) {
    OrderEntity entity = converter.convertToEntity(input);

    System.out.println(entity);
    jpaRepository.save(entity);
  }
}
