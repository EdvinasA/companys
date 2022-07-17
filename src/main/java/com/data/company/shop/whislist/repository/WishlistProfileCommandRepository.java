package com.data.company.shop.whislist.repository;

import com.data.company.shop.whislist.model.WishlistProfile;
import com.data.company.shop.whislist.repository.converter.WishlistProfileConverter;
import com.data.company.shop.whislist.repository.entity.WishlistProfileEntity;
import com.data.company.shop.whislist.repository.jpa.WishlistProfileJpaRepository;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class WishlistProfileCommandRepository {

  private final WishlistProfileJpaRepository jpaRepository;
  private final WishlistProfileConverter converter;

  @Transactional
  public void create(WishlistProfile wishlistProfile) {
    WishlistProfileEntity entity = converter.convertToEntity(wishlistProfile);

    jpaRepository.save(entity);
  }

  @Transactional
  public void delete(UUID wishlistProfileId) {
    jpaRepository.deleteById(wishlistProfileId);
  }
}
