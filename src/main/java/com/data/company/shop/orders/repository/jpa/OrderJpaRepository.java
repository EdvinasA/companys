package com.data.company.shop.orders.repository.jpa;

import com.data.company.shop.orders.repository.entities.OrderEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, UUID> {

  @Query(value = "SELECT COUNT(*) "
      + "FROM orders",
      nativeQuery = true)
  Integer findCountOfOrdersInDatabase();

  List<OrderEntity> findByUserId(UUID userId);
}
