package com.data.company.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.data.company.jwt.model.Token;
import com.data.company.jwt.repository.TokenCommandRepository;
import com.data.company.jwt.service.TokenQueryService;
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

	private final TokenCommandRepository commandRepository;
	private final TokenQueryService queryService;
	private static final long expirationDate = 9000000L;

	public String generateToken(String email) {
		try {
			Algorithm algorithm = Algorithm.HMAC256("Secret");
			Date expiration = Date.from(Instant.now().plusSeconds(expirationDate));

			String token = buildToken(email, algorithm, expiration);
			log.info("Generated token with expiration date: {}", expiration);

			commandRepository.create(new Token(UUID.randomUUID(), token, email, expiration));

			return token;
		} catch (Exception e) {
			log.error("Failed to generate token for email: {}", email);
			throw new RuntimeException(e);
		}
	}

	public boolean validateToken(String tokenForValidation) {
		Optional<Token> token = queryService.findByToken(tokenForValidation);

		if (token.isPresent() && token.get().getDate().compareTo(Date.from(Instant.now())) > 0) {
			return tokenForValidation.equals(token.get().getToken());
		}
		return false;
	}

	public Optional<Token> getTokenObject(String token) {
		return queryService.findByToken(token);
	}

	private String buildToken(String email, Algorithm algorithm, Date expiration) {
		JWTCreator.Builder jwtBuilder = JWT.create();
		return jwtBuilder
				.withIssuer(email)
				.withExpiresAt(expiration)
				.sign(algorithm);
	}
}
