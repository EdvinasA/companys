package com.data.company.shop.discount.repository.converter;

import com.data.company.shop.discount.model.DiscountedItem;
import com.data.company.shop.discount.repository.entity.DiscountedItemEntity;
import org.springframework.stereotype.Component;

@Component
public class DiscountedItemConverter {

  public DiscountedItemEntity convertToEntity(DiscountedItem input) {
    return new DiscountedItemEntity()
        .setDiscountId(input.getDiscountId())
        .setItemId(input.getItemId())
        .setId(input.getId());
  }

  public DiscountedItem convertFromEntity(DiscountedItemEntity input) {
    return new DiscountedItem()
        .setDiscountId(input.getDiscountId())
        .setItemId(input.getItemId())
        .setId(input.getId());
  }
}
