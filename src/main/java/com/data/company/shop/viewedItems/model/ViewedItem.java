package com.data.company.shop.viewedItems.model;

import java.util.UUID;
import lombok.Data;

@Data
public class ViewedItem {

  private UUID id;
  private UUID itemId;
  private String itemPicture;
  private String itemName;
  private double itemPrice;
  private boolean delivery;
  private boolean withdrawal;
  private UUID userId;
}
