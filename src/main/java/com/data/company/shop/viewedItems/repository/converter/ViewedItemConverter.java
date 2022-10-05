package com.data.company.shop.viewedItems.repository.converter;

import com.data.company.shop.products.repository.converter.ProductConverter;
import com.data.company.shop.products.repository.entity.ProductEntity;
import com.data.company.shop.products.service.ProductQueryService;
import com.data.company.shop.viewedItems.model.ViewedItem;
import com.data.company.shop.viewedItems.repository.entity.ViewedItemEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ViewedItemConverter {

	private final ProductQueryService productQueryService;
	private final ProductConverter productConverter;

	public ViewedItemEntity convertToEntity(ViewedItem input) {
		ProductEntity productEntity = productConverter.convertToEntity(productQueryService.findById(input.getItemId()));
		return new ViewedItemEntity()
				.setId(input.getId())
				.setProduct(productEntity);
	}

	public ViewedItem convertFromEntity(ViewedItemEntity entity) {
		return new ViewedItem()
				.setId(entity.getId())
				.setItemId(entity.getId())
				.setItemCode(entity.getProduct().getCode())
				.setItemPrice(entity.getProduct().getPrice())
				.setItemName(entity.getProduct().getName())
				.setSubCategory(entity.getProduct().getSubCategory())
				.setCategory(entity.getProduct().getCategory());
	}
}
