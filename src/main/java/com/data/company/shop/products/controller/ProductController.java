package com.data.company.shop.products.controller;

import com.data.company.shop.products.model.Product;
import com.data.company.shop.products.service.ProductCommandService;
import com.data.company.shop.products.service.ProductQueryService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop/product")
@AllArgsConstructor
@Slf4j
public class ProductController {

	private final ProductCommandService commandService;
	private final ProductQueryService queryService;

	@PostMapping
	public void createNewProduct(@RequestBody Product input) {
		log.info("Creating new product: {}", input);
		commandService.createNew(input);
	}

	@GetMapping
	public ResponseEntity<Page<Product>> getPageListOfProducts(@PageableDefault Pageable pageable) {
		log.info("Request for getting list of products with parameters: [Size: {}, Page: {}]", pageable.getPageSize(), pageable.getPageNumber());

		Page<Product> result = queryService.findAll(pageable);
		log.info("Retrieved list of products: [Size: {}]", result.getContent().size());

		return ResponseEntity.ok(result);
	}

	@GetMapping("{id}")
	public ResponseEntity<Product> getProductById(@PathVariable UUID id) throws NotFoundException {
		log.info("Retrieving product by id: {}", id);

		Product result = queryService.findById(id);
		log.info("Found result: {}", result);

		return ResponseEntity.ok(result);
	}
}
