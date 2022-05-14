package com.data.company.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.data.company.exceptions.TokenNotFoundException;
import com.data.company.jwt.model.TokenEntity;
import com.data.company.jwt.repository.TokenJpaRepository;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class JwtTokenGenerator {

  private final TokenJpaRepository jpaRepository;
  private static final long expirationDate = 90000000L;

  public String generateToken(String email) {
    try {
      Algorithm algorithm = Algorithm.HMAC256("Secret");
      Date expiration = Date.from(Instant.now().plusSeconds(expirationDate));

      String token = buildToken(email, algorithm, expiration);
      log.info("Generated token: {} , with expiration date: {}", token, expiration);

      jpaRepository.save(new TokenEntity(UUID.randomUUID(), token, email, expiration));

      return token;
    } catch (Exception e) {
      log.error("Failed to generate token for email: {}", email);
      throw new RuntimeException(e);
    }
  }

  public boolean validateToken(String token) {
    Optional<TokenEntity> tokenFromJpa = jpaRepository.findDistinctByToken(token);
    TokenEntity tokenEntity = tokenFromJpa
        .orElseThrow(TokenNotFoundException::new);

    if (tokenEntity.getDate().compareTo(Date.from(Instant.now())) > 0) {
      return token.equals(tokenEntity.getToken());
    }
    return false;
  }

  public TokenEntity getTokenObject(String token) {
    return jpaRepository.findDistinctByToken(token).orElse(new TokenEntity());
  }

  private String buildToken(String email, Algorithm algorithm, Date expiration) {
    JWTCreator.Builder jwtBuilder = JWT.create();
    return jwtBuilder
        .withIssuer(email)
        .withExpiresAt(expiration)
        .sign(algorithm);
  }
}
