package com.data.company.shop.shared;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ComputerAndOfficeCategory {

  LAPTOPS_AND_THEIR_ACCESSORIES("Laptops and they accessories");

  private final String category;

  ComputerAndOfficeCategory(String category) {
    this.category = category;
  }

  @JsonValue
  public String getCategory() {
    return category;
  }

}
