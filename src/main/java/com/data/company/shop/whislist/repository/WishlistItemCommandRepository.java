package com.data.company.shop.whislist.repository;

import com.data.company.shop.whislist.model.WishlistItem;
import com.data.company.shop.whislist.repository.converter.WishlistItemConverter;
import com.data.company.shop.whislist.repository.entity.WishlistItemEntity;
import com.data.company.shop.whislist.repository.jpa.WishlistItemJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class WishlistItemCommandRepository {

  private final WishlistItemJpaRepository jpaRepository;
  private final WishlistItemConverter converter;

  @Transactional
  public void create(WishlistItem input) {
    WishlistItemEntity entity = converter.convertToEntity(input);

    jpaRepository.save(entity);
  }
}
