package com.data.company.shop.whislist.service;

import com.data.company.shop.whislist.model.WishlistItem;
import com.data.company.shop.whislist.model.WishlistProfile;
import com.data.company.shop.whislist.model.WishlistProfileInput;
import com.data.company.shop.whislist.repository.WishlistProfileCommandRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WishlistProfileCommandService {

	private final WishlistProfileCommandRepository commandRepository;
	private final WishlistItemQueryService wishlistItemQueryService;
	private final WishlistItemCommandService wishlistItemCommandService;

	public UUID createWishlistProfile(WishlistProfileInput input, UUID userId) {
		WishlistProfile profile = new WishlistProfile();
		profile.setId(UUID.randomUUID());
		profile.setName(input.getName());
		profile.setUserId(userId);
		commandRepository.create(profile);

		return profile.getId();
	}

	public void deleteWishlistProfile(UUID wishlistProfileId) {
		List<WishlistItem> itemsOfProfile = wishlistItemQueryService.getListOfWishlistItems(wishlistProfileId);

		if (!itemsOfProfile.isEmpty()) {
			wishlistItemCommandService.deleteItemsFromWishlist(itemsOfProfile);
		}

		commandRepository.delete(wishlistProfileId);
	}
}
