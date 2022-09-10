package com.data.company.shop.stripe;

import com.stripe.exception.StripeException;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.model.checkout.Session;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;
import com.stripe.param.checkout.SessionCreateParams;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StripeService {

	public Session createOrder() throws StripeException {
		SessionCreateParams params =
				SessionCreateParams.builder()
						.setMode(SessionCreateParams.Mode.PAYMENT)
						.setSuccessUrl("https://example.com/success")
						.setCancelUrl("https://example.com/cancel")
						.addLineItem(
								SessionCreateParams.LineItem.builder()
										.setQuantity(1L)
										// Provide the exact Price ID (for example, pr_1234) of the product you want to sell
										.setPrice("price_1LRfMIK7iwO35NMSWnAoOxjJ")
										.build())
						.build();

		return Session.create(params);
	}

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
