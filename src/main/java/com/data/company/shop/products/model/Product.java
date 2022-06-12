package com.data.company.shop.products.model;

import java.util.UUID;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

  @NotNull
  @NotEmpty
  private String name;

  @NotNull
  private int quantity;

  @NotNull
  private double price;

  private String description;

  private String smallDescription;

  private Integer customerEvaluation;

  private boolean hasDiscount;
}
