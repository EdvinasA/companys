package com.data.company.shop.stripe;

import com.stripe.exception.StripeException;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StripeService {

  public void create() throws StripeException {
    ProductCreateParams productParams =
        ProductCreateParams.builder()
            .setName("Starter Subscription")
            .setDescription("$12/Month subscription")
            .build();
    Product product = Product.create(productParams);

    PriceCreateParams params =
        PriceCreateParams
            .builder()
            .setProduct(product.getId())
            .setCurrency("usd")
            .setUnitAmount(1200L)
            .setRecurring(
                PriceCreateParams.Recurring
                    .builder()
                    .setInterval(PriceCreateParams.Recurring.Interval.MONTH)
                    .build())
            .build();
    Price price = Price.create(params);
  }
}
