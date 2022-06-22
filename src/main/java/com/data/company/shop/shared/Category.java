package com.data.company.shop.shared;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Category {

  COMPUTER_EQUIPMENT_OFFICE_SUPPLIES("Computer equipment, office supplies");

  private final String category;

  Category(String category) {
    this.category = category;
  }

  @JsonValue
  public String getCategory() {
    return category;
  }

}
