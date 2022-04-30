package com.data.company.companyData.controller;

import com.data.company.companyData.service.CompanyCommandService;
import java.io.IOException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
@AllArgsConstructor
public class CompanyController {

  private final CompanyCommandService companyCommandService;

  @PostMapping
  public void startIngestion() throws IOException {
    companyCommandService.exportFromExcelCompanyData();
  }

}
