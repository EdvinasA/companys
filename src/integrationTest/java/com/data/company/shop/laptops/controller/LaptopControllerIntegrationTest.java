package com.data.company.shop.laptops.controller;

import com.data.company.shop.base.MvcTest;
import com.data.company.shop.extensions.WiremockExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(WiremockExtension.class)
public class LaptopControllerIntegrationTest extends MvcTest {

	//	@Test
	//	@SneakyThrows
	//	void getPageListOfLaptopsShouldReturnEmptyPageWhenNoLaptopExist() {
	//		mvc.perform(MockMvcRequestBuilders
	//				.get("/shop/laptop")
	//				.contentType(MediaType.APPLICATION_JSON)
	//				.accept(MediaType.APPLICATION_JSON))
	//				.andExpect(status().isOk())
	//				.andExpect((ResultMatcher) jsonPath("$.pageable.pageSize", is(10)));
	//	}
}
