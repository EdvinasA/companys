package com.data.company.reading.repository;

import com.data.company.reading.model.CompanyData;
import com.data.company.reading.repository.converter.CompanyDataConverter;
import com.data.company.reading.repository.entity.CompanyDataEntity;
import com.data.company.reading.repository.jpa.CompanyRepository;
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
