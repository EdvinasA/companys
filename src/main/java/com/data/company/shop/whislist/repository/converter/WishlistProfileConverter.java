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
    WishlistProfileEntity entity = new WishlistProfileEntity();
    entity.setId(profile.getId());
    entity.setName(profile.getName());
    entity.setUserId(profile.getUserId());

    return entity;
  }

  public WishlistProfile convertFromEntity(WishlistProfileEntity entity) {
    WishlistProfile profile = new WishlistProfile();
    profile.setId(entity.getId());
    profile.setName(entity.getName());
    profile.setUserId(entity.getUserId());
    profile.setItems(entity.getItems()
        .stream()
        .map(wishlistItemConverter::convertFromEntity)
        .collect(Collectors.toList()));

    return profile;
  }
}
