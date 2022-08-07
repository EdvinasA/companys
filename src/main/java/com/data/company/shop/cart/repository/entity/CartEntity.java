package com.data.company.shop.cart.repository.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity(name = "cart")
@Data
public class CartEntity {

  @Id
  private UUID id;

  @Column(name = "purchase_date")
  private LocalDateTime purchaseDate;

  @Column(name = "user_id")
  private UUID userId;

  @OneToMany(
      mappedBy = "cart",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private List<CartItemEntity> cartItems;
}
