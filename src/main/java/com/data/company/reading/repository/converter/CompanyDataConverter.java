package com.data.company.reading.repository.converter;

import com.data.company.reading.model.CompanyData;
import com.data.company.reading.repository.entity.CompanyDataEntity;

public class CompanyDataConverter {

  public CompanyDataEntity convertToEntity(CompanyData companyData) {
    CompanyDataEntity entity = new CompanyDataEntity();

    entity.setId(companyData.getId());
    entity.setCompanyForm(companyData.getCompanyForm());
    entity.setAddress(companyData.getAddress());
    entity.setCode(companyData.getCode());
    entity.setName(companyData.getName());
    entity.setRegisteredDate(companyData.getRegisteredDate());
    entity.setStatusName(companyData.getStatusName());
    entity.setStatusSinceDate(companyData.getStatusSinceDate());
    entity.setFormattedInformationDate(companyData.getFormattedInformationDate());

    return entity;
  }

}
