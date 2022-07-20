package com.data.company.shop.whislist.repository.converter;

import com.data.company.shop.whislist.model.WishlistProfile;
import com.data.company.shop.whislist.repository.entity.WishlistProfileEntity;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class WishlistProfileConverter {

  private final WishlistItemConverter wishlistItemConverter;

  public WishlistProfileEntity convertToEntity(WishlistProfile profile) {
    return new WishlistProfileEntity()
        .setId(profile.getId())
        .setName(profile.getName())
        .setUserId(profile.getUserId());
  }

  public WishlistProfile convertFromEntity(WishlistProfileEntity entity) {
    return new WishlistProfile()
        .setId(entity.getId())
        .setName(entity.getName())
        .setUserId(entity.getUserId())
        .setItems(entity.getItems()
            .stream()
            .map(wishlistItemConverter::convertFromEntity)
            .collect(Collectors.toList()));
  }
}
