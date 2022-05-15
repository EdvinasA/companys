package com.data.company.companyData.controller;

import com.data.company.companyData.model.CompanyData;
import com.data.company.companyData.service.CompanyCommandService;
import com.data.company.companyData.service.CompanyQueryService;
import com.data.company.jwt.JwtTokenGenerator;
import java.io.IOException;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
@AllArgsConstructor
@Slf4j
public class CompanyController {

  private final CompanyCommandService commandService;
  private final CompanyQueryService queryService;

  @PostMapping
  public void startIngestion() throws IOException {
    commandService.exportFromExcelCompanyData();
  }

  @GetMapping("{code}")
  public List<CompanyData> getCompanyByCode(@PathVariable String code) {
    return queryService.getByCode(code);
  }

  @GetMapping("name/{name}")
  public Page<CompanyData> getCompanyByName(@PathVariable String name, @PageableDefault Pageable pageable) {
        return queryService.findByName(name, pageable);
  }

}
