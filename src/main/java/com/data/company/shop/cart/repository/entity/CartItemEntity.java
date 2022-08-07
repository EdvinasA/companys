package com.data.company.shop.cart.repository.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity(name = "cart_item")
@Data
public class CartItemEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(name = "cart_id")
  private UUID cartId;

  @Column(name = "item_id")
  private UUID itemId;

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
}
