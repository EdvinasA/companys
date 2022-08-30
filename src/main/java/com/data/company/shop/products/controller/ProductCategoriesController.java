package com.data.company.shop.products.controller;

import com.data.company.shop.products.model.CategoryDisplay;
import com.data.company.shop.products.service.ProductCategoriesService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop/category")
@AllArgsConstructor
@Slf4j
public class ProductCategoriesController {

	private final ProductCategoriesService categoriesService;

	@GetMapping
	public ResponseEntity<List<CategoryDisplay>> getAllMainCategories() {
		log.info("Retrieving a list of main categories");

		return ResponseEntity.ok(categoriesService.getAllMainCategories());
	}

	@GetMapping("{category}")
	public ResponseEntity<List<CategoryDisplay>> getSubCategoriesByMainCategory(@PathVariable String category) {
		log.info("Retrieving a list of sub categories by main category");

		return ResponseEntity.ok(categoriesService.getSubCategoriesByMainCategory(category));
	}
}
