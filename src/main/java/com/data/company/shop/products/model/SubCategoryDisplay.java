package com.data.company.shop.products.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryDisplay {

	private String categoryForDisplay;
	private String categoryForEnum;
	private String picture;
}
