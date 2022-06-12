package com.data.company.shop.products.model;

import java.util.UUID;
import lombok.Data;

@Data
public class Product {

  private UUID id;

  private String picture;

  private String name;

  private int quantity;

  private String description;

  private String smallDescription;

  private Integer customerEvaluation;

  private boolean hasDiscount;
}
