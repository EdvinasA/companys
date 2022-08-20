package com.data.company.shop.discount.repository;

import com.data.company.shop.discount.model.DiscountedItem;
import com.data.company.shop.discount.repository.converter.DiscountedItemConverter;
import com.data.company.shop.discount.repository.jpa.DiscountedItemJpaRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Repository
public class DiscountedItemQueryRepository {

	private final DiscountedItemJpaRepository jpaRepository;
	private final DiscountedItemConverter converter;

	@Transactional
	public List<DiscountedItem> findAllDiscountedItemsByDiscountId(UUID discountId) {
		return jpaRepository.findByDiscountId(discountId)
				.stream()
				.map(converter::convertFromEntity)
				.collect(Collectors.toList());
	}
}
