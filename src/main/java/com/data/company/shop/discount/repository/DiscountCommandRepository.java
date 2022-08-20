package com.data.company.shop.discount.repository;

import com.data.company.shop.discount.model.Discount;
import com.data.company.shop.discount.repository.converter.DiscountConverter;
import com.data.company.shop.discount.repository.entity.DiscountEntity;
import com.data.company.shop.discount.repository.jpa.DiscountJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Repository
public class DiscountCommandRepository {

	private final DiscountJpaRepository jpaRepository;
	private final DiscountConverter converter;

	@Transactional
	public void create(Discount input) {
		DiscountEntity entity = converter.convertToEntity(input);

		jpaRepository.save(entity);
	}
}
