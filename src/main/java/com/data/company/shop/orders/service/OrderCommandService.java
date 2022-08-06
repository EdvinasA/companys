package com.data.company.shop.orders.service;

import com.data.company.shop.orders.model.Order;
import com.data.company.shop.orders.model.OrderInput;
import com.data.company.shop.orders.model.OrderedItems;
import com.data.company.shop.orders.repository.OrderCommandRepository;
import com.data.company.shop.orders.repository.OrderedItemsCommandRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class OrderCommandService {

  private final OrderCommandRepository commandRepository;
  private final OrderQueryService queryService;
  private final OrderedItemsCommandService orderedItemsCommandService;

  // Added Transactional if saving order to database fails, then revert changes
  @Transactional
  public void createOrder(OrderInput input) {
    LocalDate currentDate = LocalDate.now();

    Order order = Order.from(input);
    order.setId(UUID.randomUUID())
        .setOrderDate(currentDate)
        .setOrderUpdate(currentDate)
        .setOrderNumber(String.format("EA%s%s%s%s", currentDate.getYear(), currentDate.getMonthValue(), currentDate.getDayOfMonth(), queryService.getCountOfOrdersInDatabase()));

    Order savedOrder = commandRepository.create(order);
    orderedItemsCommandService.createOrderItems(input.getOrderedItems(), savedOrder.getId());
  }
}
