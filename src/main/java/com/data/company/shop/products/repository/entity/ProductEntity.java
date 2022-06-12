package com.data.company.shop.products.repository.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

  @Id
  private UUID id;

  @Column(name = "picture")
  private String picture;

  @Column(name = "name")
  private String name;

  @Column(name = "quantity")
  private int quantity;

  @Column(name = "price")
  private double price;

  @Column(name = "description")
  private String description;

  @Column(name = "small_description")
  private String smallDescription;

  @Column(name = "customer_evaluation")
  private Integer customerEvaluation;

  @Column(name = "has_discount")
  private boolean hasDiscount;
}
