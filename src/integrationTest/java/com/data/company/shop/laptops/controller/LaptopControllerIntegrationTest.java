package com.data.company.shop.laptops.controller;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.data.company.shop.base.MvcTest;
import com.data.company.shop.extensions.WiremockExtension;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(WiremockExtension.class)
public class LaptopControllerIntegrationTest extends MvcTest {

	@Test
	@SneakyThrows
	void getPageListOfLaptopsShouldReturnEmptyPageWhenNoLaptopExist() {
		mvc.perform(MockMvcRequestBuilders
				.get("/shop/laptop")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect((ResultMatcher) jsonPath("$.pageable.pageSize", is(10)));
	}
}
