package com.data.company.shop.discount.model;

import java.util.UUID;
import lombok.Data;

@Data
public class DiscountedItem {

  private Long id;
  private UUID itemId;
  private UUID discountId;
}
