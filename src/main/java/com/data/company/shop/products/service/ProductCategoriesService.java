package com.data.company.shop.products.service;

import com.data.company.shop.products.model.Category;
import com.data.company.shop.products.model.SubCategory;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductCategoriesService {

	public List<String> getAllMainCategories() {
		return Arrays.stream(Category.values())
				.map(Category::getCategory)
				.collect(Collectors.toList());
	}

	public List<String> getSubCategoriesByMainCategory(String category) {
		Category existingCategory = Category.valueOf(category);

		return Arrays.stream(SubCategory.values())
				.filter(item -> item.getMainCategoryNumber().equals(existingCategory.getCategoryNumber()))
				.map(SubCategory::getCategory)
				.collect(Collectors.toList());
	}
}
