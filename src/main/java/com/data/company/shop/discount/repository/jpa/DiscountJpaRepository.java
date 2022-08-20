package com.data.company.shop.discount.repository.jpa;

import com.data.company.shop.discount.repository.entity.DiscountEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountJpaRepository extends JpaRepository<DiscountEntity, UUID> {

}
