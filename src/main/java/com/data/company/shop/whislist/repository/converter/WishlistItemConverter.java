package com.data.company.shop.whislist.repository.converter;

import com.data.company.shop.whislist.model.WishlistItem;
import com.data.company.shop.whislist.repository.entity.WishlistItemEntity;
import org.springframework.stereotype.Component;

@Component
public class WishlistItemConverter {

  public WishlistItemEntity convertToEntity(WishlistItem item) {
    WishlistItemEntity entity = new WishlistItemEntity();
    entity.setId(item.getId());
    entity.setItemName(item.getItemName());
    entity.setItemId(item.getItemId());
    entity.setItemPicture(item.getItemPicture());
    entity.setItemPrice(item.getItemPrice());
    entity.setWishListProfileId(item.getWishListProfileId());

    return entity;
  }

  public WishlistItem convertFromEntity(WishlistItemEntity entity) {
    WishlistItem item = new WishlistItem();
    item.setId(entity.getId());
    item.setItemName(entity.getItemName());
    item.setItemId(entity.getItemId());
    item.setItemId(entity.getId());
    item.setItemPicture(entity.getItemPicture());
    item.setItemPrice(entity.getItemPrice());
    item.setWishListProfileId(entity.getWishListProfileId());

    return item;
  }
}
