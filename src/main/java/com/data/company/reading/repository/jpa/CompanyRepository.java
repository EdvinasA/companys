package com.data.company.reading.repository.jpa;

import com.data.company.reading.repository.entity.CompanyDataEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyDataEntity, UUID> {


}
