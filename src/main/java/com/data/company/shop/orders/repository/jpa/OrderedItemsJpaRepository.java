package com.data.company.shop.orders.repository.jpa;

import com.data.company.shop.orders.repository.entities.OrderedItemsEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedItemsJpaRepository extends JpaRepository<OrderedItemsEntity, UUID> {
}
