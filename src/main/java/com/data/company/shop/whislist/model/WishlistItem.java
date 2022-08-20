package com.data.company.shop.whislist.model;

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
}
