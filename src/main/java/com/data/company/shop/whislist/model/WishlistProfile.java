package com.data.company.shop.whislist.model;

import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class WishlistProfile {

  private UUID id;

  private String name;

  private List<WishlistItem> items;

  private UUID userId;
}
