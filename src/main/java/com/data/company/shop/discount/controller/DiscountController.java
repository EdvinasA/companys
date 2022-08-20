package com.data.company.shop.discount.controller;

import com.data.company.shop.discount.model.Discount;
import com.data.company.shop.discount.model.DiscountResponse;
import com.data.company.shop.discount.service.DiscountCommandService;
import com.data.company.shop.discount.service.DiscountQueryService;
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
@RequestMapping("/discount")
@AllArgsConstructor
@Slf4j
public class DiscountController {

	private final DiscountCommandService commandService;
	private final DiscountQueryService queryService;

	@PostMapping
	public ResponseEntity<Void> createDiscount(@RequestBody Discount input) {
		log.info("Received request for creating discount with input: {}", input);

		commandService.createDiscount(input);

		log.info("Discount created");
		return ResponseEntity.ok(null);
	}

	@GetMapping("{discountCode}")
	public ResponseEntity<DiscountResponse> checkIfDiscountValid(@PathVariable String discountCode) {
		log.info("Received discount code: {}, checking if valid.", discountCode);

		DiscountResponse result = queryService.checkDiscount(discountCode);
		log.info("Checked discount code and returning result: {}", result);

		return ResponseEntity.ok(result);
	}
}
