package com.data.company.shop.orders.model;

import com.data.company.shop.cart.model.CartItem;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class OrderInput {

	private UUID userId;
	private String deliveryAddress;
	private String withdrawalLocation;
	private String wantedDeliveryTime;
	private DeliveryOption deliveryOption;
	private PaymentMethod paymentMethod;
	private double totalPrice;
	private Double appliedDiscountAmount;
	private Double deliveryPrice;
	private List<CartItem> orderedItems;
	private Status status;
}
