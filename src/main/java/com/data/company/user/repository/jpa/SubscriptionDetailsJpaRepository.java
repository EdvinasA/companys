package com.data.company.user.repository.jpa;

import com.data.company.user.repository.entity.SubscriptionDetailsEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionDetailsJpaRepository extends JpaRepository<SubscriptionDetailsEntity, Long> {

	Optional<SubscriptionDetailsEntity> findByUserId(UUID userId);
}
