package com.data.company.shop.products.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

  private UUID id;

  private String picture;

  private String name;

  private int quantity;

  private double price;

  private String description;

  private String smallDescription;

  private Integer customerEvaluation;

  private boolean hasDiscount;
}
