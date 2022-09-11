package com.data.company.shop.whislist.repository.converter;

import com.data.company.shop.whislist.model.WishlistItem;
import com.data.company.shop.whislist.repository.entity.WishlistItemEntity;
import org.springframework.stereotype.Component;

@Component
public class WishlistItemConverter {

	public WishlistItemEntity convertToEntity(WishlistItem item) {
		return new WishlistItemEntity()
				.setId(item.getId())
				.setItemName(item.getItemName())
				.setItemId(item.getItemId())
				.setItemPicture(item.getItemPicture())
				.setItemPrice(item.getItemPrice())
				.setItemCode(item.getItemCode())
				.setWishListProfileId(item.getWishListProfileId())
				.setCategory(item.getCategory());
	}

	public WishlistItem convertFromEntity(WishlistItemEntity entity) {
		return new WishlistItem()
				.setId(entity.getId())
				.setItemName(entity.getItemName())
				.setItemId(entity.getItemId())
				.setItemPicture(entity.getItemPicture())
				.setItemPrice(entity.getItemPrice())
				.setItemCode(entity.getItemCode())
				.setWishListProfileId(entity.getWishListProfileId())
				.setCategory(entity.getCategory());
	}
}
