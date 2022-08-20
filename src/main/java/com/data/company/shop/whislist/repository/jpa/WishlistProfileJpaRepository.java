package com.data.company.shop.whislist.repository.jpa;

import com.data.company.shop.whislist.repository.entity.WishlistProfileEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistProfileJpaRepository extends JpaRepository<WishlistProfileEntity, UUID> {

	List<WishlistProfileEntity> findAllByUserId(UUID userId);
}
