package com.data.company.shop.whislist.model;

import java.util.UUID;
import lombok.Data;

@Data
public class WishlistItem {

  private UUID itemId;

  private String itemPicture;

  private double itemPrice;

}
