package com.data.company.shop.discount.repository;

import com.data.company.shop.discount.model.Discount;
import com.data.company.shop.discount.repository.converter.DiscountConverter;
import com.data.company.shop.discount.repository.jpa.DiscountJpaRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Repository
public class DiscountQueryRepository {

  private final DiscountJpaRepository jpaRepository;
  private final DiscountConverter converter;

  @Transactional
  public Optional<Discount> findDiscountByCode(String code) {
    return jpaRepository.findByCodeAndLatestDate(code)
        .stream()
        .map(converter::convertFromEntity)
        .findFirst();
  }
}
