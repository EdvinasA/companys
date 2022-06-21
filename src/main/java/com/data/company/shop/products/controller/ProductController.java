package com.data.company.shop.products.controller;

import com.data.company.shop.products.model.Product;
import com.data.company.shop.products.service.ProductCommandService;
import com.data.company.shop.products.service.ProductQueryService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

  @GetMapping
  public ResponseEntity<Page<Product>> getPagedProductList(@PageableDefault Pageable pageable) {
    log.info("Retrieving list of products.");
    Page<Product> products = queryService.findAllProducts(pageable);

    log.info("Retrieved {} products with parameters [Page: {}, size: {}]", products.getContent().size(), pageable.getPageNumber(), pageable.getPageSize());

    return ResponseEntity.ok(products);
  }

  @PostMapping
  public void createNewProduct(@RequestBody Product product) {
    log.info("Creating new product with name: {}", product.getName());
    commandService.createNewProduct(product);
  }

  @DeleteMapping("{productId}")
  public void deleteProduct(@PathVariable UUID productId) {
    log.info("Product with id {} is being removed from database.", productId);
    commandService.deleteProduct(productId);
  }
}
