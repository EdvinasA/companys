package com.data.company.shop.countries.controller;

import com.data.company.shop.countries.model.CountryName;
import com.data.company.shop.countries.service.CountriesCommandService;
import com.data.company.shop.countries.service.CountriesQueryService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop/countries")
@AllArgsConstructor
@Slf4j
public class CountriesController {

  private final CountriesQueryService queryService;
  private final CountriesCommandService commandService;

  @PostMapping
  public ResponseEntity<Void> ingestCountries() {
    commandService.createCountry();
    return ResponseEntity.ok(null);
  }

  @GetMapping
  public ResponseEntity<List<CountryName>> getCountries() {
    return ResponseEntity.ok(queryService.getAll());
  }
}
