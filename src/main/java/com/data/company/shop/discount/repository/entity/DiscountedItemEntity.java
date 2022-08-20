package com.data.company.shop.discount.repository.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "discount_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscountedItemEntity {

  @Id
  private Long id;

  @Column(name = "item_id")
  private UUID itemId;

  @Column(name = "discount_id")
  private UUID discountId;
}
