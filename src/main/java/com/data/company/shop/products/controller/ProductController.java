package com.data.company.shop.products.controller;

import com.data.company.shop.products.model.Product;
import com.data.company.shop.products.service.ProductCommandService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

  @PostMapping
  public void createNewProduct(@RequestBody Product product) {
    log.info("Creating new product with name: {}", product.getName());
    commandService.createNewProduct(product);
  }
}
