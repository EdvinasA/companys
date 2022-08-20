package com.data.company.shop.cart.service;

import com.data.company.shop.cart.model.Cart;
import com.data.company.shop.cart.repository.CartQueryRepository;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartQueryService {

	private final CartQueryRepository queryRepository;

	public Cart findByUserId(UUID userId) {
		return queryRepository.findByUserId(userId);
	}
}
