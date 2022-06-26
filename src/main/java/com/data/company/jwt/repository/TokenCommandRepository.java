package com.data.company.jwt.repository;

import com.data.company.jwt.model.Token;
import com.data.company.jwt.repository.converter.TokenConverter;
import com.data.company.jwt.repository.entity.TokenEntity;
import com.data.company.jwt.repository.jpa.TokenJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class TokenCommandRepository {

  private final TokenJpaRepository jpaRepository;
  private final TokenConverter converter;

  @Transactional
  public void create(Token token) {
    TokenEntity entity = converter.convertToEntity(token);

    jpaRepository.save(entity);
  }
}
