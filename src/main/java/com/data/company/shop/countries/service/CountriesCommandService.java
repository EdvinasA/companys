package com.data.company.shop.countries.service;

import com.data.company.shop.countries.client.CountriesClient;
import com.data.company.shop.countries.model.Country;
import com.data.company.shop.countries.repository.CountriesCommandRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountriesCommandService {

	private final CountriesCommandRepository commandRepository;
	private final CountriesClient client;

	public void createCountry() {
		List<Country> countries = client.getCountries();
		countries
				.forEach(country -> commandRepository.create(country.getName().getCommon()));
	}
}
