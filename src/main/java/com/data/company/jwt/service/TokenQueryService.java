package com.data.company.jwt.service;

import com.data.company.jwt.model.Token;
import com.data.company.jwt.repository.TokenQueryRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TokenQueryService {

  private final TokenQueryRepository queryRepository;

  public Optional<Token> findByToken(String token) {
    return queryRepository.findByToken(token);
  }
}
