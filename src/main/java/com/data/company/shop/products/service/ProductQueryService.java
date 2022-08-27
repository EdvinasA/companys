package com.data.company.shop.products.service;

import com.data.company.shop.products.model.Product;
import com.data.company.shop.products.repository.ProductQueryRepository;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductQueryService {

	private final ProductQueryRepository queryRepository;

	public Page<Product> findAll(Pageable pageable) {
		return queryRepository.findAll(pageable);
	}

	public Product findById(UUID id) throws NotFoundException {
		return queryRepository.findById(id);
	}
}