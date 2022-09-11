package com.data.company.shop.cart.repository.converter;

import com.data.company.shop.cart.model.CartItem;
import com.data.company.shop.cart.repository.entity.CartItemEntity;
import org.springframework.stereotype.Component;

@Component
public class CartItemConverter {

	public CartItemEntity convertToEntity(CartItem input) {
		return new CartItemEntity()
				.setItemId(input.getItemId())
				.setPicture(input.getPicture())
				.setItemName(input.getItemName())
				.setItemCode(input.getItemCode())
				.setItemQuantity(input.getItemQuantity())
				.setItemPrice(input.getItemPrice())
				.setItemInsurance(input.isItemInsurance())
				.setItemWarranty(input.isItemWarranty())
				.setCategory(input.getCategory());
	}

	public CartItem convertFromEntity(CartItemEntity input) {
		return new CartItem()
				.setItemId(input.getItemId())
				.setPicture(input.getPicture())
				.setItemName(input.getItemName())
				.setItemCode(input.getItemCode())
				.setItemQuantity(input.getItemQuantity())
				.setItemPrice(input.getItemPrice())
				.setItemInsurance(input.isItemInsurance())
				.setItemWarranty(input.isItemWarranty())
				.setCategory(input.getCategory());
	}
}
