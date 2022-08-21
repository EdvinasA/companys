package com.data.company.shop.orders.repository.entities;

import com.data.company.shop.orders.model.DeliveryOption;
import com.data.company.shop.orders.model.PaymentMethod;
import com.data.company.shop.orders.model.Status;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

	@Id
	private UUID id;

	@Column(name = "user_id")
	private UUID userId;

	@Column(name = "order_number")
	private String orderNumber;

	@Column(name = "order_date")
	private LocalDate orderDate;

	@Column(name = "delivery_address")
	private String deliveryAddress;

	@Column(name = "withdrawal_location")
	private String withdrawalLocation;

	@Column(name = "wanted_delivery_time")
	private String wantedDeliveryTime;

	@Column(name = "collect_option")
	@Enumerated(value = EnumType.STRING)
	private DeliveryOption deliveryOption;

	@Column(name = "payment_method")
	@Enumerated(value = EnumType.STRING)
	private PaymentMethod paymentMethod;

	@Column(name = "invoice")
	private File invoice;

	@Column(name = "total_price")
	private double totalPrice;

	@Column(name = "applied_discount_amount")
	private Double appliedDiscountAmount;

	@Column(name = "delivery_price")
	private Double deliveryPrice;

	@Column(name = "order_update")
	private LocalDate orderUpdate;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "order_id")
	private List<OrderedItemsEntity> orderedItems = new ArrayList<>();

	@Column(name = "status")
	@Enumerated(value = EnumType.STRING)
	private Status status;
}
