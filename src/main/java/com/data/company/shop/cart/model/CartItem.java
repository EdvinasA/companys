package com.data.company.shop.cart.model;

import java.util.UUID;
import lombok.Data;

@Data
public class CartItem {

	private Long id;
	private UUID itemId;
	private String picture;
	private String itemName;
	private String itemCode;
	private Integer itemQuantity;
	private double itemPrice;
	private boolean itemInsurance;
	private boolean itemWarranty;
}
