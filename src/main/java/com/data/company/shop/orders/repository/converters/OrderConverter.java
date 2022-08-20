package com.data.company.shop.orders.repository.converters;

import com.data.company.shop.orders.model.Order;
import com.data.company.shop.orders.repository.entities.OrderEntity;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class OrderConverter {

	private final OrderedItemsConverter orderedItemsConverter;

	public OrderEntity convertToEntity(Order order) {
		return new OrderEntity()
				.setId(order.getId())
				.setUserId(order.getUserId())
				.setCollectOption(order.getCollectOption())
				.setOrderDate(order.getOrderDate())
				.setOrderNumber(order.getOrderNumber())
				.setOrderUpdate(order.getOrderUpdate())
				.setPaymentMethod(order.getPaymentMethod())
				.setStatus(order.getStatus())
				.setOrderedItems(
						order.getOrderedItems()
								.stream()
								.map(orderedItemsConverter::convertToEntity)
								.collect(Collectors.toList()))
				.setTotalPrice(order.getTotalPrice());
	}

	public Order convertFromEntity(OrderEntity entity) {
		return new Order()
				.setId(entity.getId())
				.setUserId(entity.getUserId())
				.setCollectOption(entity.getCollectOption())
				.setOrderDate(entity.getOrderDate())
				.setOrderNumber(entity.getOrderNumber())
				.setOrderUpdate(entity.getOrderUpdate())
				.setPaymentMethod(entity.getPaymentMethod())
				.setStatus(entity.getStatus())
				.setOrderedItems(
						entity.getOrderedItems()
								.stream()
								.map(orderedItemsConverter::convertFromEntity)
								.collect(Collectors.toList()))
				.setTotalPrice(entity.getTotalPrice());
	}
}
