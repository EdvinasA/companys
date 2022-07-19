package com.data.company.shop.viewedItems.repository;

import com.data.company.shop.viewedItems.model.ViewedItem;
import com.data.company.shop.viewedItems.repository.converter.ViewedItemConverter;
import com.data.company.shop.viewedItems.repository.jpa.ViewedItemJpaRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ViewedItemQueryRepository {

  private final ViewedItemJpaRepository jpaRepository;
  private final ViewedItemConverter converter;

  public List<ViewedItem> getListOfViewedItems(UUID userId) {
    return jpaRepository.findByUserId(userId)
        .stream()
        .map(converter::convertFromEntity)
        .collect(Collectors.toList());
  }
}
