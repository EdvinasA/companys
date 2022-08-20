package com.data.company.shop.discount.model;

import java.util.List;
import lombok.Data;

@Data
public class DiscountResponse {

  private Boolean expired;
  private Integer percent;
  private String code;
  private List<DiscountedItem> items;
  private Boolean forAllItems;
}
