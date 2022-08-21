package com.data.company.shop.orders.model;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class Order {

	private UUID id;
	private UUID userId;
	private String orderNumber;
	private LocalDate orderDate;
	private DeliveryOption deliveryOption;
	private PaymentMethod paymentMethod;
	private List<OrderedItems> orderedItems;
	private File invoice;
	private double totalPrice;
	private LocalDate orderUpdate;
	private Status status;
}
