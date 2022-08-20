package com.data.company.shop.discount.repository.jpa;

import com.data.company.shop.discount.repository.entity.DiscountedItemEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountedItemJpaRepository extends JpaRepository<DiscountedItemEntity, Long> {

	List<DiscountedItemEntity> findByDiscountId(UUID discountId);
}
