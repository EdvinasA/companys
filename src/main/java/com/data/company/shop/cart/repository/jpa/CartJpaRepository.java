package com.data.company.shop.cart.repository.jpa;

import com.data.company.shop.cart.repository.entity.CartEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartJpaRepository extends JpaRepository<CartEntity, UUID> {

  @Query(value = "SELECT * FROM cart WHERE user_id = :userId AND status = 'FILLING'",
      nativeQuery = true)
  Optional<CartEntity> findByUserId(@Param("userId") UUID userId);
}
