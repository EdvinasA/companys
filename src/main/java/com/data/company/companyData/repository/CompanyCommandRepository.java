package com.data.company.companyData.repository;

import com.data.company.companyData.model.CompanyData;
import com.data.company.companyData.repository.converter.CompanyDataConverter;
import com.data.company.companyData.repository.entity.CompanyDataEntity;
import com.data.company.companyData.repository.jpa.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class CompanyCommandRepository {

  private final CompanyRepository companyCommandRepository;
  private final CompanyDataConverter companyDataConverter;

  @Transactional
  public void save(CompanyData companyData) {
    CompanyDataEntity entity = companyDataConverter.convertToEntity(companyData);

    companyCommandRepository.save(entity);
  }

}
