package com.data.company.shop.orders.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate orderDate;
	private String deliveryAddress;
	private String withdrawalLocation;
	private String wantedDeliveryTime;
	private DeliveryOption deliveryOption;
	private PaymentMethod paymentMethod;
	private List<OrderedItems> orderedItems;
	private File invoice;
	private double totalPrice;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate orderUpdate;
	private Status status;
}
