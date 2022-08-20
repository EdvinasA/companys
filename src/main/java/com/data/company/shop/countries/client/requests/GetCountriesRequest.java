package com.data.company.shop.countries.client.requests;

import com.data.company.executor.ExternalServiceRequest;
import com.data.company.shop.countries.model.Country;
import java.util.List;
import java.util.Optional;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

public class GetCountriesRequest extends ExternalServiceRequest<Void, List<Country>> {

	@Override
	public HttpMethod getHttpMethod() {
		return HttpMethod.GET;
	}

	@Override
	public String getEndpoint() {
		return "/v3.1/region/americas";
	}

	@Override
	public String getOperationName() {
		return "getCountries";
	}

	@Override
	public Optional<List<Country>> fallbackResponse() {
		return Optional.empty();
	}

	@Override
	public ParameterizedTypeReference<List<Country>> getResponseBody() {
		return new ParameterizedTypeReference<>() {};
	}
}
