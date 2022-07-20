package com.data.company.shop.viewedItems.repository.converter;

import com.data.company.shop.viewedItems.model.ViewedItem;
import com.data.company.shop.viewedItems.repository.entity.ViewedItemEntity;
import org.springframework.stereotype.Component;

@Component
public class ViewedItemConverter {

  public ViewedItemEntity convertToEntity(ViewedItem input) {
    ViewedItemEntity entity = new ViewedItemEntity();
    entity.setId(input.getId());
    entity.setItemId(input.getItemId());
    entity.setItemName(input.getItemName());
    entity.setItemPicture(input.getItemPicture());
    entity.setItemPrice(input.getItemPrice());
    entity.setDelivery(input.isDelivery());
    entity.setWithdrawal(input.isWithdrawal());
    entity.setUserId(input.getUserId());

    return entity;
  }

  public ViewedItem convertFromEntity(ViewedItemEntity entity) {
    ViewedItem item = new ViewedItem();
    item.setId(entity.getId());
    item.setItemId(entity.getItemId());
    item.setItemName(entity.getItemName());
    item.setItemPicture(entity.getItemPicture());
    item.setItemPrice(entity.getItemPrice());
    item.setDelivery(entity.isDelivery());
    item.setWithdrawal(entity.isWithdrawal());
    item.setUserId(entity.getUserId());

    return item;
  }
}
