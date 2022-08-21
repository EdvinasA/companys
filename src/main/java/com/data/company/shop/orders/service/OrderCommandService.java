package com.data.company.shop.orders.service;

import com.data.company.shop.cart.model.CartItem;
import com.data.company.shop.cart.service.CartCommandService;
import com.data.company.shop.orders.model.Order;
import com.data.company.shop.orders.model.OrderInput;
import com.data.company.shop.orders.model.OrderedItems;
import com.data.company.shop.orders.model.Status;
import com.data.company.shop.orders.repository.OrderCommandRepository;
import java.time.LocalDate;
import java.util.List;
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

	// Added Transactional if saving order to database fails, then revert changes
	@Transactional
	public void createOrder(OrderInput input, UUID userId) {
		LocalDate currentDate = LocalDate.now();

		Order order = new Order();
		order
				.setId(UUID.randomUUID())
				.setUserId(userId)
				.setOrderDate(currentDate)
				.setOrderUpdate(currentDate)
				.setStatus(Status.ORDERED)
				.setTotalPrice(input.getTotalPrice())
//				.setPaymentMethod()
				.setOrderedItems(input.getOrderedItems()
						.stream()
						.map(OrderedItems::from)
						.collect(Collectors.toList()))
				.setOrderNumber(String.format("EA%s%s%s%s",
						currentDate.getYear(),
						currentDate.getMonthValue(),
						currentDate.getDayOfMonth(),
						queryService.getCountOfOrdersInDatabase()));

		commandRepository.create(order);

		cartCommandService.moveCartToOrder(userId);
	}
}
