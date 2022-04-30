package com.data.company.companyData.service;

import com.data.company.companyData.model.CompanyData;
import com.data.company.companyData.repository.CompanyQueryRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyQueryService {

  private final CompanyQueryRepository companyQueryRepository;

  public List<CompanyData> getByCode(String code) {
    return companyQueryRepository.findByCode(code);
  }

}
