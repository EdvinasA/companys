package com.data.company.shop.viewedItems.model;

import com.data.company.shop.products.model.Category;
import com.data.company.shop.products.model.SubCategory;
import java.util.UUID;
import lombok.Data;

@Data
public class ViewedItem {

	private UUID id;
	private UUID itemId;
	private String itemPicture;
	private String itemName;
	private String itemCode;
	private double itemPrice;
	private boolean delivery;
	private boolean withdrawal;
	private UUID userId;
	private Category category;
	private SubCategory subCategory;
}
