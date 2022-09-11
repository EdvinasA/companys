package com.data.company.shop.orders.model;

import com.data.company.shop.cart.model.CartItem;
import com.data.company.shop.products.model.Category;
import com.data.company.shop.products.model.SubCategory;
import java.util.UUID;
import lombok.Data;

@Data
public class OrderedItems {

	private Long id;
	private UUID itemId;
	private String picture;
	private String itemName;
	private String itemCode;
	private double itemPrice;
	private Integer itemQuantity;
	private boolean itemInsurance;
	private boolean itemWarranty;
	private Category category;
	private SubCategory subCategory;

	public static OrderedItems from(CartItem cartItem) {
		return new OrderedItems()
				.setItemId(cartItem.getItemId())
				.setPicture(cartItem.getPicture())
				.setItemName(cartItem.getItemName())
				.setItemCode(cartItem.getItemCode())
				.setItemPrice(cartItem.getItemPrice())
				.setItemQuantity(cartItem.getItemQuantity())
				.setItemInsurance(cartItem.isItemInsurance())
				.setItemWarranty(cartItem.isItemWarranty());
	}
}
