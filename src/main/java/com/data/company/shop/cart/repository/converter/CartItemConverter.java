package com.data.company.shop.cart.repository.converter;

import com.data.company.shop.cart.model.CartItem;
import com.data.company.shop.cart.repository.entity.CartItemEntity;
import com.data.company.shop.products.repository.converter.ProductConverter;
import com.data.company.shop.products.repository.entity.ProductEntity;
import com.data.company.shop.products.service.ProductQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CartItemConverter {

	private final ProductQueryService productQueryService;
	private final ProductConverter productConverter;

	public CartItemEntity convertToEntity(CartItem input) {
		ProductEntity productEntity = productConverter.convertToEntity(productQueryService.findById(input.getItemId()));

		return new CartItemEntity()
				.setProduct(productEntity)
				.setItemQuantity(input.getItemQuantity())
				.setItemInsurance(input.isItemInsurance())
				.setItemWarranty(input.isItemWarranty());
	}

	public CartItem convertFromEntity(CartItemEntity input) {
		return new CartItem()
				.setItemId(input.getProduct().getId())
				.setPicture(input.getProduct().getPicture())
				.setItemName(input.getProduct().getName())
				.setItemCode(input.getProduct().getCode())
				.setItemQuantity(input.getItemQuantity())
				.setItemPrice(input.getProduct().getPrice())
				.setItemInsurance(input.isItemInsurance())
				.setItemWarranty(input.isItemWarranty())
				.setCategory(input.getProduct().getCategory())
				.setSubCategory(input.getProduct().getSubCategory());
	}
}
