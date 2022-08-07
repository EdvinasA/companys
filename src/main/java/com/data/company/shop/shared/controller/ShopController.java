package com.data.company.shop.shared.controller;

import com.data.company.shop.shared.model.Categories;
import com.data.company.shop.shared.service.ShopQueryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop/categories")
@AllArgsConstructor
@Slf4j
public class ShopController {

  private final ShopQueryService queryService;

  @GetMapping
  public ResponseEntity<Categories> getCategories() {
    log.info("Retrieving list of categories");

    Categories result = queryService.getCategories();

    return ResponseEntity.ok(result);
  }
}
