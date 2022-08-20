package com.data.company.shop.discount.model;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Data;

@Data
public class Discount {

  private UUID id;
  private String code;
  private int percent;
  private LocalDate validUntil;
  private boolean forAllItems;
}
