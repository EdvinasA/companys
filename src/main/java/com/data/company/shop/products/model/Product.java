package com.data.company.shop.products.model;

import com.data.company.shop.shared.Category;
import com.data.company.shop.shared.SubCategory;
import java.util.UUID;
import lombok.Data;

@Data
public class Product {

	private UUID id;
	private String name;
	private String picture;
	private String code;
	private double price;
	private int quantity;
	private String type;
	private Category category;
	private SubCategory subCategory;
	private String stripeProductId;
}
