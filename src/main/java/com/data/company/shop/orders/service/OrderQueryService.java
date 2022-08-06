package com.data.company.shop.orders.service;

import com.data.company.shop.orders.model.Order;
import com.data.company.shop.orders.repository.OrderQueryRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderQueryService {

  private final OrderQueryRepository queryRepository;

  public Integer getCountOfOrdersInDatabase() {
    return queryRepository.getCountOfOrdersInDatabase();
  }

  public List<Order> findAllByUserId(UUID userId) {
    return queryRepository.findAllByUserId(userId);
  }
}
