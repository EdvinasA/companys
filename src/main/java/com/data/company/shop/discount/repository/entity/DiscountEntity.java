package com.data.company.shop.discount.repository.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "discount")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscountEntity {

  @Id
  private UUID id;

  @Column(name = "code")
  private String code;

  @Column(name = "percent")
  private int percent;

  @Column(name = "valid_until")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate validUntil;

  @Column(name = "for_all_items")
  private boolean forAllItems;
}
