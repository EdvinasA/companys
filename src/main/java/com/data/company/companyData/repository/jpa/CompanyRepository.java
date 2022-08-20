package com.data.company.companyData.repository.jpa;

import com.data.company.companyData.repository.entity.CompanyDataEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyDataEntity, UUID> {

	List<CompanyDataEntity> findByCode(String id);

	Page<CompanyDataEntity> findByNameContains(String name, Pageable pageable);
}
