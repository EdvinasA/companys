package com.data.company.shop.products.service;

import com.data.company.shop.products.model.Product;
import com.data.company.shop.products.queries.ProductSearchQuery;
import com.data.company.shop.products.repository.ProductQueryRepository;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductQueryService {

	private final ProductQueryRepository queryRepository;

	public Page<Product> findAll(Pageable pageable, ProductSearchQuery query) {
		return queryRepository.findAll(pageable, query);
	}

	public Product findById(UUID id) {
		Optional<Product> product = queryRepository.findById(id);
		return product.orElse(null);
	}
}
