package com.data.company.shop.orders.model;

import java.util.UUID;
import lombok.Data;

@Data
public class OrderedItems {

  private Long id;
  private UUID itemId;
  private UUID orderId;
  private String picture;
  private String itemName;
  private String itemCode;
  private double itemPrice;
  private Integer itemQuantity;
  private boolean itemInsurance;
  private boolean itemWarranty;
}
