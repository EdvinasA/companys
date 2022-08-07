package com.data.company.shop.cart.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Data
public class Cart {

  private UUID id;
  private LocalDateTime purchaseDate;
  private UUID userId;
  private CartStatus status;

}
