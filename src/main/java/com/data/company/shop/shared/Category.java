package com.data.company.shop.shared;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Category {

  COMPUTER_EQUIPMENT_OFFICE_SUPPLIES("Computer equipment, office supplies"),
  COMPUTER_COMPONENTS("Computer components"),
  TV_AUDIO_VIDEO_GAMES_COMPUTERS("TV, audio, video, games computers");

  private final String category;

  Category(String category) {
    this.category = category;
  }

  @JsonValue
  public String getCategory() {
    return category;
  }

}
