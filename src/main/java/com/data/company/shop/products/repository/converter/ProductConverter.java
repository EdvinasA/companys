package com.data.company.shop.products.repository.converter;

import com.data.company.shop.products.model.Product;
import com.data.company.shop.products.repository.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

	public ProductEntity convertToEntity(Product input) {
		return new ProductEntity()
				.setId(input.getId())
				.setName(input.getName())
				.setPicture(input.getPicture())
				.setCode(input.getCode())
				.setPrice(input.getPrice())
				.setQuantity(input.getQuantity())
				.setType(input.getType())
				.setCategory(input.getCategory())
				.setStripeProductId(input.getStripeProductId());
	}

	public Product convertFromEntity(ProductEntity input) {
		return new Product()
				.setId(input.getId())
				.setName(input.getName())
				.setPicture(input.getPicture())
				.setCode(input.getCode())
				.setPrice(input.getPrice())
				.setQuantity(input.getQuantity())
				.setType(input.getType())
				.setCategory(input.getCategory())
				.setStripeProductId(input.getStripeProductId());
	}
}
