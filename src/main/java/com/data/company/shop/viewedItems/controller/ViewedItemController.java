package com.data.company.shop.viewedItems.controller;

import com.data.company.shop.viewedItems.model.ViewedItem;
import com.data.company.shop.viewedItems.service.ViewedItemCommandService;
import com.data.company.shop.viewedItems.service.ViewedItemQueryService;
import com.data.company.shop.viewedItems.validators.ViewedItemValidator;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/viewed-item/{userId}")
@AllArgsConstructor
@Slf4j
public class ViewedItemController {

	private final ViewedItemCommandService commandService;
	private final ViewedItemQueryService queryService;
	private final ViewedItemValidator validator;

	@PostMapping
	public ResponseEntity<Void> createViewedItemForUser(@RequestBody ViewedItem input,
			@PathVariable UUID userId) {

		boolean isTrue = validator.validate(input);

		if (isTrue) {
			return ResponseEntity.ok(null);
		}

		log.info("Creating viewed item for user with ID: {}", userId);
		commandService.saveViewedItem(input);

		return ResponseEntity.ok(null);
	}

	@GetMapping
	public ResponseEntity<List<ViewedItem>> getAllViewedItemsForUser(@PathVariable UUID userId) {
		log.info("Retrieving list of all viewed items for user with ID: {}", userId);

		List<ViewedItem> result = queryService.getViewedItemsByUserId(userId);
		log.info("Retrieved list of viewed items: [Size: {}]", result.size());

		return ResponseEntity.ok(result);
	}
}
