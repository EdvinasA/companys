package com.data.company.shop.cart.repository;

import com.data.company.shop.cart.repository.entity.CartEntity;
import com.data.company.shop.cart.repository.jpa.CartItemJpaRepository;
import com.data.company.shop.cart.repository.jpa.CartJpaRepository;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class CartItemCommandRepository {

	private final CartJpaRepository cartJpaRepository;
	private final CartItemJpaRepository jpaRepository;

	@Transactional
	public void deleteAllCartItems(UUID cartId) {
		Optional<CartEntity> cartEntity = cartJpaRepository.findByIdNative(cartId);

		cartEntity.ifPresent(jpaRepository::deleteByCart);
	}
}
