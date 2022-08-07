package com.data.company.shop.cart.model;

import java.util.UUID;
import lombok.Data;

@Data
public class CartItem {

  private Long id;
  private UUID cartId;
  private UUID itemId;
  private String picture;
  private String productName;
  private String productCode;
  private int quantity;
  private double price;
  private boolean insurance;
  private boolean warranty;
}
