package com.data.company.shop.whislist.service;

import com.data.company.shop.whislist.model.WishlistProfile;
import com.data.company.shop.whislist.repository.WishlistProfileQueryRepository;
import com.stripe.exception.StripeException;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WishlistProfileQueryService {

	private final WishlistProfileQueryRepository queryRepository;

	public List<WishlistProfile> findProfilesByUserId(UUID userId) throws StripeException {
		return queryRepository.getAllWishlistProfilesByUserId(userId);
	}
}
