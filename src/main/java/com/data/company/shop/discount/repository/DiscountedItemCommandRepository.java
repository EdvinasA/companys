package com.data.company.shop.discount.repository;

import com.data.company.shop.discount.model.DiscountedItem;
import com.data.company.shop.discount.repository.converter.DiscountedItemConverter;
import com.data.company.shop.discount.repository.entity.DiscountedItemEntity;
import com.data.company.shop.discount.repository.jpa.DiscountedItemJpaRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Repository
public class DiscountedItemCommandRepository {

  private final DiscountedItemJpaRepository jpaRepository;
  private final DiscountedItemConverter converter;

  @Transactional
  public void create(List<DiscountedItem> input) {
    List<DiscountedItemEntity> entities = input.stream()
        .map(converter::convertToEntity)
        .collect(Collectors.toList());

    jpaRepository.saveAll(entities);
  }
}
