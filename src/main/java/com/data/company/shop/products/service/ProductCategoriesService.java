package com.data.company.shop.products.service;

import com.data.company.shop.products.model.Category;
import com.data.company.shop.products.model.CategoryDisplay;
import com.data.company.shop.products.model.SubCategory;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductCategoriesService {

	public List<CategoryDisplay> getAllMainCategories() {
		return Arrays.stream(Category.values())
				.map(category -> new CategoryDisplay(category.getCategory(), category.getCategoryAsEnum(), ""))
				.collect(Collectors.toList());
	}

	public List<CategoryDisplay> getSubCategoriesByMainCategory(String category) {
		return Arrays.stream(SubCategory.values())
				.filter(item -> item.getMainCategoryNumber().equals(Category.valueOf(category).getCategoryNumber()))
				.map(subCategory -> new CategoryDisplay(subCategory.getCategory(), "", subCategory.getPicture()))
				.collect(Collectors.toList());
	}
}
