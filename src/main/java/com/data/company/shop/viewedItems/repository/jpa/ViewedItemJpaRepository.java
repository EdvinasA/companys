package com.data.company.shop.viewedItems.repository.jpa;

import com.data.company.shop.viewedItems.repository.entity.ViewedItemEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewedItemJpaRepository extends JpaRepository<ViewedItemEntity, UUID> {

	List<ViewedItemEntity> findByUserId(UUID userId);

	Optional<ViewedItemEntity> findByItemIdAndUserId(UUID itemId, UUID userId);
}
