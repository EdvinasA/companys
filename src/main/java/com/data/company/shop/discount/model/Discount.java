package com.data.company.shop.discount.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Data
public class Discount {

  private UUID id;
  private String code;
  private int percent;
  private LocalDateTime validUntil;
  private boolean forAllItems;
}
