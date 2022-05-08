package com.data.company.companyData.controller;

import com.data.company.companyData.model.CompanyData;
import com.data.company.companyData.service.CompanyCommandService;
import com.data.company.companyData.service.CompanyQueryService;
import com.data.company.jwt.JwtTokenGenerator;
import java.io.IOException;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
  private final JwtTokenGenerator jwtTokenGenerator;

  @PostMapping
  public void startIngestion() throws IOException {
    commandService.exportFromExcelCompanyData();
  }

  @GetMapping("{code}")
  public List<CompanyData> getCompanyByCode(@PathVariable String code) {
    return queryService.getByCode(code);
  }

  @GetMapping("name/{name}")
  public List<CompanyData> getCompanyByName(@PathVariable String name) {
    String token = jwtTokenGenerator.generateToken(name);

    return queryService.findByName(name);
  }

}
