package com.data.company.shop.laptops.controller;

import com.data.company.shop.laptops.model.Laptop;
import com.data.company.shop.laptops.repository.LaptopQueryRepository;
import com.data.company.shop.laptops.service.LaptopCommandService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop/laptop")
@AllArgsConstructor
@Slf4j
public class LaptopController {

  private final LaptopCommandService commandService;
  private final LaptopQueryRepository queryRepository;

  @PostMapping
  public void createNewLaptopObject(@RequestBody Laptop laptop) {
    log.info("Creating laptop object: {}", laptop);
    commandService.createNew(laptop);
  }

  @GetMapping
  public ResponseEntity<Page<Laptop>> getPageListOfLaptops(@PageableDefault Pageable pageable) {
    log.info("Request for getting list of laptops with parameters: [Size: {}, Page: {}]", pageable.getPageSize(), pageable.getPageNumber());

    Page<Laptop> result = queryRepository.findAll(pageable);
    log.info("Retrieved list of laptops: [Size: {}]", result.getContent().size());

    return ResponseEntity.ok(result);
  }
}
