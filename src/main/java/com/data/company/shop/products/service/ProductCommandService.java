package com.data.company.shop.products.service;

import com.data.company.shop.products.model.Product;
import com.data.company.shop.products.repository.ProductCommandRepository;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductCommandService {

	private final ProductCommandRepository commandRepository;

	public void createNew(Product input) {
		input.setId(UUID.randomUUID());

		commandRepository.create(input);
	}
}
