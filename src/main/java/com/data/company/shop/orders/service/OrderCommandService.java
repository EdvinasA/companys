package com.data.company.shop.orders.service;

import com.data.company.shop.cart.service.CartCommandService;
import com.data.company.shop.orders.model.Order;
import com.data.company.shop.orders.model.OrderInput;
import com.data.company.shop.orders.model.OrderedItems;
import com.data.company.shop.orders.model.Status;
import com.data.company.shop.orders.repository.OrderCommandRepository;
import com.data.company.shop.stripe.StripeService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.checkout.Session;
import java.time.LocalDate;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class OrderCommandService {

	private final OrderCommandRepository commandRepository;
	private final OrderQueryService queryService;
	private final CartCommandService cartCommandService;
	private final StripeService stripeService;

	// Added Transactional if saving order to database fails, then revert changes
	@Transactional
	public void createOrder(OrderInput input, UUID userId) throws StripeException {
		LocalDate currentDate = LocalDate.now();

		Order order = new Order();
		order
				.setId(UUID.randomUUID())
				.setUserId(userId)
				.setOrderDate(currentDate)
				.setOrderUpdate(currentDate)
				.setStatus(Status.ORDERED)
				.setDeliveryAddress(input.getDeliveryAddress())
				.setWantedDeliveryTime(input.getWantedDeliveryTime())
				.setWithdrawalLocation(input.getWithdrawalLocation())
				.setTotalPrice(input.getTotalPrice())
				.setDeliveryOption(input.getDeliveryOption())
				.setPaymentMethod(input.getPaymentMethod())
				.setOrderedItems(input.getOrderedItems()
						.stream()
						.map(OrderedItems::from)
						.collect(Collectors.toList()))
				.setOrderNumber(String.format("EA%s%s%s%s",
						currentDate.getYear(),
						currentDate.getMonthValue(),
						currentDate.getDayOfMonth(),
						queryService.getCountOfOrdersInDatabase()));

//		for (OrderedItems orderedItem : order.getOrderedItems()) {
//			stripeService.createProductWithPrice(orderedItem.getItemName(), orderedItem.getItemPrice());
//		}

		Session url = stripeService.createOrder();
		System.out.println(url);
//		commandRepository.create(order);

//		cartCommandService.moveCartToOrder(userId);
	}
}
