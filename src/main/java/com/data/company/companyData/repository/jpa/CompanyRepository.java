package com.data.company.companyData.repository.jpa;

import com.data.company.companyData.repository.entity.CompanyDataEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyDataEntity, UUID> {


}
