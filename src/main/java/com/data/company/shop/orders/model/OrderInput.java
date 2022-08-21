package com.data.company.shop.orders.model;

import com.data.company.shop.cart.model.CartItem;
import java.io.File;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class OrderInput {

	private UUID userId;
	private DeliveryOption deliveryOption;
	private PaymentMethod paymentMethod;
	private double totalPrice;
	private List<CartItem> orderedItems;
	private Status status;
}
