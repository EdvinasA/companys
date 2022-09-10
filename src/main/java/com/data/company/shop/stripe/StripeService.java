package com.data.company.shop.stripe;

import com.data.company.shop.cart.model.CartItem;
import com.data.company.shop.orders.model.OrderedItems;
import com.stripe.exception.StripeException;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.model.checkout.Session;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;
import com.stripe.param.checkout.SessionCreateParams;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StripeService {

	public Session createOrder(List<CartItem> items) throws StripeException {
		SessionCreateParams params =
				SessionCreateParams.builder()
						.setMode(SessionCreateParams.Mode.PAYMENT)
						.setSuccessUrl("http://localhost:4200")
						.setCancelUrl("http://localhost:4200/category/COMPUTER_EQUIPMENT_OFFICE_SUPPLIES")
						.addAllLineItem(createPrice(items))
						.build();

		return Session.create(params);
	}

	private List<SessionCreateParams.LineItem> createPrice(List<CartItem> items) {
		List<SessionCreateParams.LineItem> createdLineItems = new ArrayList<>();
		for (CartItem item : items) {
			SessionCreateParams.LineItem lineItem = SessionCreateParams.LineItem.builder()
					.setQuantity((long) item.getItemQuantity())
					// Provide the exact Price ID (for example, pr_1234) of the product you want to sell
					.setPrice("price_1LRfMIK7iwO35NMSWnAoOxjJ")
					.build();
			createdLineItems.add(lineItem);
		}
		return createdLineItems;
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
