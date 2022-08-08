package com.data.company.shop.cart.repository.entity;

import com.data.company.shop.cart.model.CartStatus;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private CartStatus status;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cart")
  private List<CartItemEntity> cartItems = new ArrayList<>();
}
