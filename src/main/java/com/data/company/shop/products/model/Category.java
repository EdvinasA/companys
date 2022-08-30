package com.data.company.shop.products.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Category {

	COMPUTER_EQUIPMENT_OFFICE_SUPPLIES("Computer equipment, office supplies", "COMPUTER_EQUIPMENT_OFFICE_SUPPLIES", 1),
	COMPUTER_COMPONENTS("Computer components", "COMPUTER_COMPONENTS", 2),
	TV_AUDIO_VIDEO_GAMES_COMPUTERS("TV, audio, video, games computers", "TV_AUDIO_VIDEO_GAMES_COMPUTERS", 3);

	private final String category;
	private final String categoryAsEnum;
	private final Integer categoryNumber;

	Category(String category, String categoryAsEnum, Integer categoryNumber) {
		this.category = category;
		this.categoryAsEnum = categoryAsEnum;
		this.categoryNumber = categoryNumber;
	}

	@JsonValue
	public String getCategory() {
		return category;
	}

	public String getCategoryAsEnum() {
		return categoryAsEnum;
	}

	public Integer getCategoryNumber() {
		return categoryNumber;
	}

}
