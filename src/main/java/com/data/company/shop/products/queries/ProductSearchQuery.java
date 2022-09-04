package com.data.company.shop.products.queries;

import com.data.company.shop.products.model.SubCategory;
import lombok.Data;

@Data
public class ProductSearchQuery {

	private Double price;
	private SubCategory subCategory;
}
