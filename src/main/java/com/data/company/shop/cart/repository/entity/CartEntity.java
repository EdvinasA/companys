package com.data.company.shop.cart.repository.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity(name = "cart")
@Data
public class CartEntity {

  @Id
  private UUID id;

  @Column(name = "picture")
  private String picture;

  @Column(name = "product_name")
  private String productName;

  @Column(name = "product_code")
  private String productCode;

  @Column(name = "quantity")
  private int quantity;

  @Column(name = "price")
  private double price;

  @Column(name = "insurance")
  private boolean insurance;

  @Column(name = "warranty")
  private boolean warranty;

  @Column(name = "purchase_date")
  private LocalDateTime purchaseDate;
}
