package com.data.company.jwt.repository;

import com.data.company.jwt.model.Token;
import com.data.company.jwt.repository.converter.TokenConverter;
import com.data.company.jwt.repository.jpa.TokenJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class TokenQueryRepository {

  private final TokenJpaRepository jpaRepository;
  private final TokenConverter converter;

  public Token findByToken(String token) {
    return jpaRepository.findDistinctByToken(token)
        .map(converter::convertFromEntity)
        .orElse(new Token());
  }
}
