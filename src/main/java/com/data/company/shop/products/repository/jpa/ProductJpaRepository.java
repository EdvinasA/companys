package com.data.company.shop.products.repository.jpa;

import com.data.company.shop.products.repository.entity.ProductEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, UUID> {

}
