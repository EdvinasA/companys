package com.data.company.shop.whislist.repository.converter;

import com.data.company.shop.whislist.model.WishlistItem;
import com.data.company.shop.whislist.repository.entity.WishlistItemEntity;
import org.springframework.stereotype.Component;

@Component
public class WishlistItemConverter {

  public WishlistItemEntity convertToEntity(WishlistItem item) {
    WishlistItemEntity entity = new WishlistItemEntity();
    entity.setId(item.getItemId());
    entity.setItemPicture(item.getItemPicture());
    entity.setItemPrice(item.getItemPrice());

    return entity;
  }

  public WishlistItem convertFromEntity(WishlistItemEntity entity) {
    WishlistItem item = new WishlistItem();
    item.setItemId(entity.getId());
    item.setItemPicture(entity.getItemPicture());
    item.setItemPrice(entity.getItemPrice());

    return item;
  }
}
