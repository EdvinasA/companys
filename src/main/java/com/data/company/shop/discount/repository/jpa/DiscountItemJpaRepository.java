package com.data.company.shop.discount.repository.jpa;

import com.data.company.shop.discount.repository.entity.DiscountedItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountItemJpaRepository extends JpaRepository<DiscountedItemEntity, Long> {

}
