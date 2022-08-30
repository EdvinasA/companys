package com.data.company.shop.products.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDisplay {

	private String categoryForDisplay;
	private String categoryForEnum;
}
