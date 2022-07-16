package com.data.company.shop.whislist.repository;

import com.data.company.shop.whislist.model.WishlistProfile;
import com.data.company.shop.whislist.repository.converter.WishlistProfileConverter;
import com.data.company.shop.whislist.repository.jpa.WishlistProfileJpaRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class WishlistProfileQueryRepository {

  private final WishlistProfileJpaRepository jpaRepository;
  private final WishlistProfileConverter converter;

  public List<WishlistProfile> getAllWishlistProfilesByUserId(UUID userId) {
    return jpaRepository.findAllByUserId(userId)
        .stream()
        .map(converter::convertFromEntity)
        .collect(Collectors.toList());
  }
}
