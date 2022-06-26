package com.data.company.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.data.company.exceptions.TokenNotFoundException;
import com.data.company.jwt.model.TokenEntity;
import com.data.company.jwt.repository.TokenJpaRepository;
import com.data.company.user.model.Token;
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

  public Token generateToken(String email) {
    try {
      Algorithm algorithm = Algorithm.HMAC256("Secret");
      Date expiration = Date.from(Instant.now().plusSeconds(expirationDate));

      String token = buildToken(email, algorithm, expiration);
      log.info("Generated token with expiration date: {}", expiration);

      jpaRepository.save(new TokenEntity(UUID.randomUUID(), token, email, expiration));

      return new Token(token);
    } catch (Exception e) {
      log.error("Failed to generate token for email: {}", email);
      throw new RuntimeException(e);
    }
  }

  public boolean validateToken(String token) {
    Optional<TokenEntity> tokenFromJpa = jpaRepository.findDistinctByToken(token);

    if (tokenFromJpa.isEmpty()) {
      return false;
    }

    TokenEntity tokenEntity = tokenFromJpa.get();

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
