package com.data.company.shop.discount.repository.converter;

import com.data.company.shop.discount.model.Discount;
import com.data.company.shop.discount.repository.entity.DiscountEntity;
import org.springframework.stereotype.Component;

@Component
public class DiscountConverter {

	public DiscountEntity convertToEntity(Discount input) {
		return new DiscountEntity()
				.setId(input.getId())
				.setCode(input.getCode())
				.setPercent(input.getPercent())
				.setForAllItems(input.isForAllItems())
				.setValidUntil(input.getValidUntil());
	}

	public Discount convertFromEntity(DiscountEntity input) {
		return new Discount()
				.setId(input.getId())
				.setCode(input.getCode())
				.setPercent(input.getPercent())
				.setForAllItems(input.isForAllItems())
				.setValidUntil(input.getValidUntil());
	}
}
