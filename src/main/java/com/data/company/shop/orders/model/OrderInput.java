package com.data.company.shop.orders.model;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class OrderInput {

  private UUID userId;
  private String orderNumber;
  private LocalDate orderDate;
  private String collectOption;
  private String paymentMethod;
  private File invoice;
  private double totalPrice;
  private List<OrderedItems> orderedItems;
  private LocalDate orderUpdate;
  private Status status;
}
