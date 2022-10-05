package com.data.company.shop.orders.repository.converters;

import com.data.company.shop.orders.model.OrderedItems;
import com.data.company.shop.orders.repository.entities.OrderedItemsEntity;
import com.data.company.shop.products.repository.converter.ProductConverter;
import com.data.company.shop.products.repository.entity.ProductEntity;
import com.data.company.shop.products.service.ProductQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class OrderedItemsConverter {

	private final ProductQueryService productQueryService;
	private final ProductConverter productConverter;

	public OrderedItemsEntity convertToEntity(OrderedItems item) {
		ProductEntity productEntity = productConverter.convertToEntity(productQueryService.findById(item.getProductId()));
		return new OrderedItemsEntity()
				.setItemQuantity(item.getItemQuantity())
				.setItemWarranty(item.isItemWarranty())
				.setItemInsurance(item.isItemInsurance())
				.setProduct(productEntity);
	}

	public OrderedItems convertFromEntity(OrderedItemsEntity entity) {
		return new OrderedItems()
				.setItemCode(entity.getProduct().getCode())
				.setItemId(entity.getProduct().getId())
				.setItemName(entity.getProduct().getName())
				.setItemPrice(entity.getProduct().getPrice())
				.setItemQuantity(entity.getItemQuantity())
				.setItemInsurance(entity.isItemInsurance())
				.setItemWarranty(entity.isItemWarranty())
				.setPicture(entity.getProduct().getPicture())
				.setCategory(entity.getProduct().getCategory())
				.setSubCategory(entity.getProduct().getSubCategory());
	}
}
