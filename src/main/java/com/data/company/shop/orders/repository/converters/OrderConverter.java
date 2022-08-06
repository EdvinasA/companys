package com.data.company.shop.orders.repository.converters;

import com.data.company.shop.orders.model.Order;
import com.data.company.shop.orders.repository.entities.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {

  public OrderEntity convertToEntity(Order order) {
    return new OrderEntity()
        .setId(order.getId())
        .setUserId(order.getUserId())
        .setCollectOption(order.getCollectOption())
        .setOrderDate(order.getOrderDate())
        .setOrderNumber(order.getOrderNumber())
        .setOrderUpdate(order.getOrderUpdate())
        .setPaymentMethod(order.getPaymentMethod())
        .setStatus(order.getStatus())
        .setTotalPrice(order.getTotalPrice());
  }

  public Order convertFromEntity(OrderEntity entity) {
    return new Order()
        .setId(entity.getId())
        .setUserId(entity.getUserId())
        .setCollectOption(entity.getCollectOption())
        .setOrderDate(entity.getOrderDate())
        .setOrderNumber(entity.getOrderNumber())
        .setOrderUpdate(entity.getOrderUpdate())
        .setPaymentMethod(entity.getPaymentMethod())
        .setStatus(entity.getStatus())
        .setTotalPrice(entity.getTotalPrice());
  }
}
