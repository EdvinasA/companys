package com.data.company.shop.laptops.service;

import com.data.company.shop.laptops.model.Laptop;
import com.data.company.shop.laptops.repository.LaptopCommandRepository;
import com.data.company.shop.laptops.repository.LaptopQueryRepository;
import com.data.company.shop.stripe.StripeService;
import com.stripe.exception.StripeException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LaptopCommandService {

	private final LaptopCommandRepository commandRepository;
	private final LaptopQueryRepository queryRepository;
	private final StripeService stripeService;

	public void createNew(Laptop laptop) {
		laptop.setId(UUID.randomUUID());

		commandRepository.save(laptop);
	}

	public void updateLaptop() {
		List<Laptop> laptops = queryRepository.findAll();

		laptops
				.forEach(laptop -> {
					try {
						if (Objects.isNull(laptop.getStripeProductId())) {
							String productId = stripeService
									.createProductWithPrice(laptop.getName(), laptop.getPrice());
							laptop.setStripeProductId(productId);
							commandRepository.update(laptop);
						}
					} catch (StripeException e) {
						e.printStackTrace();
					}
				});
	}
}
