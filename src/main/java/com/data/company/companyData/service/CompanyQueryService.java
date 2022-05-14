package com.data.company.companyData.service;

import com.data.company.companyData.model.CompanyData;
import com.data.company.companyData.repository.CompanyQueryRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CompanyQueryService {

  private final CompanyQueryRepository companyQueryRepository;

  public List<CompanyData> getByCode(String code) {
    return companyQueryRepository.findByCode(code);
  }

  public Page<CompanyData> findByName(String name, Pageable pageable) {
    return companyQueryRepository.findByNameLike(name, pageable);
  }

}
