package com.data.company.shop.cart.repository.entity;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity(name = "cart")
@Data
public class CartEntity {

  @Id
  private UUID id;
}
