package com.data.company.shop.whislist.service;

import com.data.company.shop.whislist.model.WishlistItem;
import com.data.company.shop.whislist.repository.WishlistItemCommandRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WishlistItemCommandService {

  private final WishlistItemCommandRepository commandRepository;

  public void addItemToWishlistProfile(WishlistItem input) {
    input.setId(UUID.randomUUID());
    commandRepository.create(input);
  }

  public void deleteItemsFromWishlist(List<WishlistItem> items) {
    commandRepository.delete(items);
  }
}
