package com.data.company.user.repository;

import com.data.company.user.model.SubscriptionDetails;
import com.data.company.user.repository.converter.SubscriptionDetailsConverter;
import com.data.company.user.repository.jpa.SubscriptionDetailsJpaRepository;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class SubscriptionDetailsQueryRepository {

  private final SubscriptionDetailsJpaRepository jpaRepository;
  private final SubscriptionDetailsConverter converter;

  public SubscriptionDetails findByUserId(UUID userId) {
    return jpaRepository.findByUserId(userId)
        .map(converter::convertFromEntity)
        .orElseThrow(EntityNotFoundException::new);
  }
}
