package com.data.company.shop.whislist.repository;

import com.data.company.shop.whislist.model.WishlistItem;
import com.data.company.shop.whislist.repository.converter.WishlistItemConverter;
import com.data.company.shop.whislist.repository.jpa.WishlistItemJpaRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class WishlistItemQueryRepository {

	private final WishlistItemJpaRepository jpaRepository;
	private final WishlistItemConverter converter;

	public List<WishlistItem> getWishlistItems(UUID wishlistProfileId) {
		return jpaRepository.findByWishListProfileId(wishlistProfileId)
				.stream()
				.map(converter::convertFromEntity)
				.collect(Collectors.toList());
	}
}
