package com.data.company.companyData.controller;

import com.data.company.companyData.model.CompanyData;
import com.data.company.companyData.service.CompanyCommandService;
import com.data.company.companyData.service.CompanyQueryService;
import java.io.IOException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
@AllArgsConstructor
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

}
