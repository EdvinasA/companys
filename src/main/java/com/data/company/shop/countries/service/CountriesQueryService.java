package com.data.company.shop.countries.service;

import com.data.company.shop.countries.model.CountryName;
import com.data.company.shop.countries.repository.CountriesQueryRepository;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountriesQueryService {

	private final CountriesQueryRepository queryRepository;

	public List<CountryName> getAll() {
		return queryRepository.getAll()
				.stream()
				.sorted(Comparator.comparing(CountryName::getCommon))
				.collect(Collectors.toList());
	}

}
