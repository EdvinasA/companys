package com.data.company.shop.cart.repository.jpa;

import com.data.company.shop.cart.repository.entity.CartEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartJpaRepository extends JpaRepository<CartEntity, UUID> {

}
