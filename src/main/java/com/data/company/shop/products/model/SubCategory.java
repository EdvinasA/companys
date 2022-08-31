package com.data.company.shop.products.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SubCategory {

	LAPTOPS_AND_THEIR_ACCESSORIES("Laptops and they accessories", "LAPTOPS_AND_THEIR_ACCESSORIES",  1, "https://ksd-images.lt/display/onea_lt/uploads/ctcp/3638/6011d6a6.jpg?h=330&op=thumbnail&w=400"),
	MONITORS_STATIONARY_COMPUTER_UPS("Monitors, stationary computers and UPS", "MONITORS_STATIONARY_COMPUTER_UPS", 1, "https://ksd-images.lt/display/onea_lt/uploads/ctcp/3630/9a1ebc80.jpg?h=330&op=thumbnail&w=400"),
	HEADPHONES_MICROPHONES_AND_COMPUTER_SPEAKERS("Headphones, microphones and computer speakers", "HEADPHONES_MICROPHONES_AND_COMPUTER_SPEAKERS", 1, "https://ksd-images.lt/display/onea_lt/uploads/ctcp/3632/4908d57b.jpg?h=330&op=thumbnail&w=400"),
	EXTERNAL_EQUIPMENT_AND_OPERATIONAL_SYSTEMS("External equipment and operational systems", "EXTERNAL_EQUIPMENT_AND_OPERATIONAL_SYSTEMS", 1, "https://ksd-images.lt/display/onea_lt/uploads/ctcp/3633/a3aaca4b.jpg?h=330&op=thumbnail&w=400"),
	ELECTRONIC_DATA_CARRIERS("Electronic data carriers", "ELECTRONIC_DATA_CARRIERS", 1, "https://ksd-images.lt/display/onea_lt/uploads/ctcp/3631/26e02861.jpg?h=330&op=thumbnail&w=400"),
	GAMER_EQUIPMENT("Gamer equipment", "GAMER_EQUIPMENT", 1, "https://ksd-images.lt/display/onea_lt/uploads/ctcp/3640/2d776704.jpg?h=330&op=thumbnail&w=400"),
	PRINTERS_AND_SCANNERS("Printers and scanners", "PRINTERS_AND_SCANNERS",  1, "https://ksd-images.lt/display/onea_lt/uploads/ctcp/3634/0bb05791.jpg?h=330&op=thumbnail&w=400"),
	MAIN_MATERIALS_FOR_PRINTERS("Main materials for printers", "MAIN_MATERIALS_FOR_PRINTERS", 1, "https://ksd-images.lt/display/onea_lt/uploads/ctcp/3635/e48a2f9a.jpg?h=330&op=thumbnail&w=400");

	private final String category;
	private final String enumValue;
	private final Integer mainCategoryNumber;
	private final String picture;

	SubCategory(String category, String enumValue, Integer mainCategoryNumber, String picture) {
		this.category = category;
		this.enumValue = enumValue;
		this.mainCategoryNumber = mainCategoryNumber;
		this.picture = picture;
	}

	@JsonValue
	public String getCategory() {
		return category;
	}

	public String getEnumValue() {
		return enumValue;
	}

	public String getPicture() {
		return picture;
	}

	public Integer getMainCategoryNumber() {
		return mainCategoryNumber;
	}

}
