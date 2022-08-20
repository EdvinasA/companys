package com.data.company.shop.products.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.data.company.shop.laptops.controller.LaptopController;
import com.data.company.shop.laptops.model.Laptop;
import com.data.company.shop.laptops.service.LaptopCommandService;
import com.data.company.shop.laptops.service.LaptopQueryService;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class LaptopControllerTest {

	@Mock
	LaptopCommandService commandService;

	@Mock
	LaptopQueryService queryService;

	@InjectMocks
	private LaptopController controller;

	@Test
	void getPageListOfLaptopsShouldReturnListOfLaptops() {
		when(queryService.findAll(Pageable.ofSize(10))).thenReturn(new PageImpl<>(List.of(new Laptop(), new Laptop())));

		ResponseEntity<Page<Laptop>> result = controller.getPageListOfLaptops(Pageable.ofSize(10));

		assertAll(
				() -> assertNotNull(Objects.requireNonNull(result.getBody()).getContent()),
				() -> assertEquals(2, Objects.requireNonNull(result.getBody()).getContent().size()));
	}

	@Test
	void createLaptop() {
		controller.createNewLaptopObject(buildInput());

		verify(commandService, times(1)).createNew(buildInput());
	}

	private Laptop buildInput() {
		Laptop laptop = new Laptop();
		laptop.setName("test");
		return laptop;
	}

}
