package com.data.company.shop.orders.model;

import java.util.UUID;
import lombok.Data;

@Data
public class OrderedItems {

  private UUID id;
  private UUID itemId;
  private String picture;
  private String itemName;
  private String itemCode;
  private double itemPrice;
  private Integer itemQuantity;
}
