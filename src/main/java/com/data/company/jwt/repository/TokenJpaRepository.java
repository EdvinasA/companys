package com.data.company.jwt.repository;

import com.data.company.jwt.model.TokenEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenJpaRepository extends JpaRepository<TokenEntity, UUID> {

  Optional<TokenEntity> findDistinctByToken(String token);
}
