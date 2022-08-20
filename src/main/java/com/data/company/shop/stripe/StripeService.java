package com.data.company.shop.stripe;

import com.stripe.exception.StripeException;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StripeService {

	public String createProductWithPrice(String productName, double productPrice) throws StripeException {
		Product product = createProduct(productName);
		PriceCreateParams params = getPriceCreateParams(product, productPrice);
		Price.create(params);
		return product.getId();
	}

	private PriceCreateParams getPriceCreateParams(Product product, double productPrice) {
		return PriceCreateParams
				.builder()
				.setProduct(product.getId())
				.setCurrency("EUR")
				.setUnitAmountDecimal(BigDecimal.valueOf(productPrice))
				.build();
	}

	private Product createProduct(String name) throws StripeException {
		ProductCreateParams productParams = ProductCreateParams.builder()
				.setName(name)
				.build();
		return Product.create(productParams);
	}
}
