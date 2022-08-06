package com.data.company.shop.orders.repository.converters;

import com.data.company.shop.orders.model.OrderedItems;
import com.data.company.shop.orders.repository.entities.OrderedItemsEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderedItemsConverter {

  public OrderedItemsEntity convertToEntity(OrderedItems item) {
    return new OrderedItemsEntity()
        .setItemCode(item.getItemCode())
        .setItemId(item.getItemId())
        .setItemName(item.getItemName())
        .setItemPrice(item.getItemPrice())
        .setItemQuantity(item.getItemQuantity())
        .setOrderId(item.getOrderId())
        .setPicture(item.getPicture());
  }

  public OrderedItems convertFromEntity(OrderedItemsEntity entity) {
    return new OrderedItems()
        .setItemCode(entity.getItemCode())
        .setItemId(entity.getItemId())
        .setItemName(entity.getItemName())
        .setItemPrice(entity.getItemPrice())
        .setItemQuantity(entity.getItemQuantity())
        .setOrderId(entity.getOrderId())
        .setPicture(entity.getPicture());
  }
}
