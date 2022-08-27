package com.data.company.shop.orders.repository;

import com.data.company.shop.orders.model.Order;
import com.data.company.shop.orders.repository.converters.OrderConverter;
import com.data.company.shop.orders.repository.jpa.OrderJpaRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class OrderQueryRepository {

	private final OrderJpaRepository jpaRepository;
	private final OrderConverter converter;

	public Integer getCountOfOrdersInDatabase() {
		return jpaRepository.findCountOfOrdersInDatabase();
	}

	public List<Order> findAllByUserId(UUID userId) {
		return jpaRepository.findByUserId(userId)
				.stream()
				.map(converter::convertFromEntity)
				.collect(Collectors.toList());
	}

	public Order findByOrderId(UUID orderId) {
		return jpaRepository.findById(orderId)
				.map(converter::convertFromEntity)
				.orElseThrow(EntityNotFoundException::new);
	}
}
