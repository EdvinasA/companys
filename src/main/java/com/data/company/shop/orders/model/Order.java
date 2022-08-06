package com.data.company.shop.orders.model;

import java.io.File;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Data;

@Data
public class Order {

  private UUID id;
  private UUID userId;
  private String orderNumber;
  private LocalDate orderDate;
  private String collectOption;
  private String paymentMethod;
  private File invoice;
  private double totalPrice;
  private LocalDate orderUpdate;
  private Status status;

  public static Order from(OrderInput input) {
    return new Order()
        .setCollectOption(input.getCollectOption())
        .setUserId(input.getUserId())
        .setOrderNumber(input.getOrderNumber())
        .setOrderDate(input.getOrderDate())
        .setPaymentMethod(input.getPaymentMethod())
        .setTotalPrice(input.getTotalPrice())
        .setOrderUpdate(input.getOrderUpdate())
        .setStatus(input.getStatus());
  }
}
