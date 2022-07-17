package com.data.company.shop.whislist.service;

import com.data.company.shop.whislist.model.WishlistItem;
import com.data.company.shop.whislist.repository.WishlistItemQueryRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WishlistItemQueryService {

  private final WishlistItemQueryRepository queryRepository;

  public List<WishlistItem> getListOfWishlistItems(UUID wishlistProfileId) {
    return queryRepository.getWishlistItems(wishlistProfileId);
  }
}
