package com.data.company.shop.shared;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SubCategory {

	LAPTOPS_AND_THEIR_ACCESSORIES("Laptops and they accessories", 1),
	MONITORS_STATIONARY_COMPUTER_UPS("Monitors, stationary computers and UPS", 1),
	HEADPHONES_MICROPHONES_AND_COMPUTER_SPEAKERS("Headphones, microphones and computer speakers", 1);
	HEADPHONES_MICROPHONES_AND_COMPUTER_SPEAKERS("Headphones, microphones and computer speakers", 1);

	private final String category;
	private final Integer mainCategoryNumber;

	SubCategory(String category, Integer mainCategoryNumber) {
		this.category = category;
		this.mainCategoryNumber = mainCategoryNumber;
	}

	@JsonValue
	public String getCategory() {
		return category;
	}

	public Integer getMainCategoryNumber() {
		return mainCategoryNumber;
	}

}
