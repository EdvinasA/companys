package com.data.company.shop.viewedItems.repository;

import com.data.company.shop.viewedItems.model.ViewedItem;
import com.data.company.shop.viewedItems.repository.converter.ViewedItemConverter;
import com.data.company.shop.viewedItems.repository.entity.ViewedItemEntity;
import com.data.company.shop.viewedItems.repository.jpa.ViewedItemJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class ViewedItemCommandRepository {

  private final ViewedItemJpaRepository jpaRepository;
  private final ViewedItemConverter converter;

  @Transactional
  public void create(ViewedItem viewedItem) {
    ViewedItemEntity entity = converter.convertToEntity(viewedItem);

    jpaRepository.save(entity);
  }
}
