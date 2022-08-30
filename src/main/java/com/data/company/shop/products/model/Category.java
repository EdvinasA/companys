package com.data.company.shop.products.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Category {

	COMPUTER_EQUIPMENT_OFFICE_SUPPLIES("Computer equipment, office supplies", 1),
	COMPUTER_COMPONENTS("Computer components", 2),
	TV_AUDIO_VIDEO_GAMES_COMPUTERS("TV, audio, video, games computers", 3);

	private final String category;
	private final Integer categoryNumber;

	Category(String category, Integer categoryNumber) {
		this.category = category;
		this.categoryNumber = categoryNumber;
	}

	@JsonValue
	public String getCategory() {
		return category;
	}

	public Integer getCategoryNumber() {
		return categoryNumber;
	}

}
