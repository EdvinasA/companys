package com.data.company.shop.products.service;

import com.data.company.shop.products.model.Product;
import com.data.company.shop.products.repository.ProductCommandRepository;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ProductCommandService {

	private final ProductCommandRepository commandRepository;

	public void createNew(Product input) {
		input.setId(UUID.randomUUID());

		commandRepository.create(input);
	}

	@Transactional
	public void update(Product input) {
		commandRepository.update(input);
	}
}
