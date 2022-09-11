package com.data.company.shop.stripe;

import com.data.company.shop.cart.model.CartItem;
import com.data.company.shop.products.service.ProductCommandService;
import com.data.company.shop.products.service.ProductQueryService;
import com.data.company.shop.stripe.model.CreatedProduct;
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
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StripeService {

	private final ProductQueryService productQueryService;
	private final ProductCommandService productCommandService;

	public Session createOrder(List<CartItem> items) throws StripeException, NotFoundException {
		SessionCreateParams params = SessionCreateParams.builder()
				.setMode(SessionCreateParams.Mode.PAYMENT)
				.setSuccessUrl("http://localhost:4200/checkout/success")
				.setCancelUrl("http://localhost:4200/checkout/failed")
				.addAllLineItem(createPrice(items))
				.build();

		return Session.create(params);
	}

	private List<SessionCreateParams.LineItem> createPrice(List<CartItem> items) throws NotFoundException, StripeException {
		List<SessionCreateParams.LineItem> createdLineItems = new ArrayList<>();
		for (CartItem item : items) {

			com.data.company.shop.products.model.Product product = productQueryService.findById(item.getItemId());
			if (Objects.isNull(product.getStripePriceId())) {
				CreatedProduct createdProduct = createProductWithPrice(product.getName(), product.getPrice());
				product.setStripeProductId(createdProduct.getStripeProductId());
				product.setStripePriceId(createdProduct.getStripePriceId());
				productCommandService.update(product);
			}

			SessionCreateParams.LineItem lineItem = SessionCreateParams.LineItem.builder()
					.setQuantity((long) item.getItemQuantity())
					.setPrice(product.getStripePriceId())
					.build();
			createdLineItems.add(lineItem);
		}

		return createdLineItems;
	}

	public CreatedProduct createProductWithPrice(String productName, double productPrice) throws StripeException {
		Product product = createProduct(productName);
		PriceCreateParams params = getPriceCreateParams(product, productPrice);
		Price createdPrice = Price.create(params);
		return new CreatedProduct().setStripeProductId(product.getId()).setStripePriceId(createdPrice.getId());
	}

	private PriceCreateParams getPriceCreateParams(Product product, double productPrice) {
		return PriceCreateParams
				.builder()
				.setProduct(product.getId())
				.setCurrency("EUR")
				.setUnitAmountDecimal(BigDecimal.valueOf(productPrice * 100))
				.build();
	}

	private Product createProduct(String name) throws StripeException {
		ProductCreateParams productParams = ProductCreateParams.builder()
				.setName(name)
				.build();
		return Product.create(productParams);
	}
}
