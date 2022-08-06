package com.data.company.shop.orders.repository.jpa;

import com.data.company.shop.orders.repository.entities.OrderEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, UUID> {

}
