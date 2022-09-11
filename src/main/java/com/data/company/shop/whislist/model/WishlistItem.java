package com.data.company.shop.whislist.model;

import com.data.company.shop.products.model.Category;
import com.data.company.shop.products.model.SubCategory;
import java.util.UUID;
import lombok.Data;

@Data
public class WishlistItem {

	private UUID id;
	private UUID itemId;
	private String itemName;
	private String itemCode;
	private String itemPicture;
	private double itemPrice;
	private UUID wishListProfileId;
	private Category category;
	private SubCategory subCategory;
}
