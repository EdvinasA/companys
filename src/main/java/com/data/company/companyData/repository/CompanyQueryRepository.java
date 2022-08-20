package com.data.company.companyData.repository;

import com.data.company.companyData.model.CompanyData;
import com.data.company.companyData.repository.converter.CompanyDataConverter;
import com.data.company.companyData.repository.jpa.CompanyRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CompanyQueryRepository {

	private final CompanyRepository companyRepository;
	private final CompanyDataConverter companyDataConverter;

	public List<CompanyData> findByCode(String code) {
		return companyRepository.findByCode(code)
				.stream()
				.map(companyDataConverter::convertFromEntity)
				.collect(Collectors.toList());
	}

	public Page<CompanyData> findByNameLike(String name, Pageable pageable) {
		return companyRepository.findByNameContains(name, pageable)
				.map(companyDataConverter::convertFromEntity);
	}

}
