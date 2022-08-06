package com.data.company.shop.orders.service;

import com.data.company.shop.orders.repository.OrderedItemsQueryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderedItemsQueryService {

  private final OrderedItemsQueryRepository queryRepository;
}
