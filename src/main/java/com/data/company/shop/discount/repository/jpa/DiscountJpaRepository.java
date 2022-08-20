package com.data.company.shop.discount.repository.jpa;

import com.data.company.shop.discount.repository.entity.DiscountEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DiscountJpaRepository extends JpaRepository<DiscountEntity, UUID> {

	@Query(value = "SELECT * FROM discount "
			+ "WHERE valid_until = (SELECT MAX(valid_until) FROM discount WHERE code = :code) "
			+ "AND code = :code", nativeQuery = true)
	Optional<DiscountEntity> findByCodeAndLatestDate(@Param("code") String code);
}
