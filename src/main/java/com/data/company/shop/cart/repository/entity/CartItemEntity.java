package com.data.company.shop.cart.repository.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity(name = "cart_items")
@Data
public class CartItemEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  private CartEntity cart;

  @Column(name = "item_id")
  private UUID itemId;

  @Column(name = "picture")
  private String picture;

  @Column(name = "item_name")
  private String itemName;

  @Column(name = "item_code")
  private String itemCode;

  @Column(name = "item_quantity")
  private int itemQuantity;

  @Column(name = "item_price")
  private double itemPrice;

  @Column(name = "item_insurance")
  private boolean itemInsurance;

  @Column(name = "item_warranty")
  private boolean itemWarranty;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CartItemEntity )) return false;
    return id != null && id.equals(((CartItemEntity) o).getId());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
