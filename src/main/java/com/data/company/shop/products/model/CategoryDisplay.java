package com.data.company.shop.products.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDisplay {

	private String categoryForDisplay;
	private String categoryForEnum;
	private String picture;
	private List<SubCategoryDisplay> subCategoryDisplay;
}
