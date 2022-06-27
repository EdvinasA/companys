package com.data.company.shop.cart.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Data
public class Cart {

  private UUID id;
  private String picture;
  private String productName;
  private String productCode;
  private int quantity;
  private double price;
  private boolean insurance;
  private boolean warranty;
  private LocalDateTime purchaseDate;
  private UUID userId;

}
