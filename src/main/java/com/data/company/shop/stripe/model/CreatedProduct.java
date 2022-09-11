package com.data.company.shop.stripe.model;

import lombok.Data;

@Data
public class CreatedProduct {

	private String stripeProductId;
	private String stripePriceId;
}
