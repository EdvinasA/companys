package com.data.company.shop.whislist.repository.jpa;

import com.data.company.shop.whislist.repository.entity.WishlistItemEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistItemJpaRepository extends JpaRepository<WishlistItemEntity, UUID> {

    List<WishlistItemEntity> findByWishListProfileId(UUID wishlistProfileId);
}
