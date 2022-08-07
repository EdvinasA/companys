package com.data.company.shop.orders.repository.entities;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "ordered_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderedItemsEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(name = "item_id")
  private UUID itemId;

  @Column(name = "order_id")
  private UUID orderId;

  @Column(name = "user_id")
  private UUID userId;

  @Column(name = "picture")
  private String picture;

  @Column(name = "item_name")
  private String itemName;

  @Column(name = "item_code")
  private String itemCode;

  @Column(name = "item_price")
  private double itemPrice;

  @Column(name = "item_quantity")
  private Integer itemQuantity;

  @Column(name = "item_insurance")
  private boolean itemInsurance;

  @Column(name = "item_warranty")
  private boolean itemWarranty;
}
