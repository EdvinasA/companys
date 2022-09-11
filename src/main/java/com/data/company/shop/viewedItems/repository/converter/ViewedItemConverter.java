package com.data.company.shop.viewedItems.repository.converter;

import com.data.company.shop.viewedItems.model.ViewedItem;
import com.data.company.shop.viewedItems.repository.entity.ViewedItemEntity;
import org.springframework.stereotype.Component;

@Component
public class ViewedItemConverter {

	public ViewedItemEntity convertToEntity(ViewedItem input) {
		return new ViewedItemEntity()
				.setId(input.getId())
				.setItemId(input.getItemId())
				.setItemName(input.getItemName())
				.setItemPicture(input.getItemPicture())
				.setItemPrice(input.getItemPrice())
				.setDelivery(input.isDelivery())
				.setWithdrawal(input.isWithdrawal())
				.setUserId(input.getUserId())
				.setItemCode(input.getItemCode())
				.setCategory(input.getCategory())
				.setSubCategory(input.getSubCategory());
	}

	public ViewedItem convertFromEntity(ViewedItemEntity entity) {
		return new ViewedItem()
				.setId(entity.getId())
				.setItemId(entity.getItemId())
				.setItemName(entity.getItemName())
				.setItemPicture(entity.getItemPicture())
				.setItemPrice(entity.getItemPrice())
				.setDelivery(entity.isDelivery())
				.setWithdrawal(entity.isWithdrawal())
				.setUserId(entity.getUserId())
				.setItemCode(entity.getItemCode())
				.setCategory(entity.getCategory())
				.setSubCategory(entity.getSubCategory());
	}
}
