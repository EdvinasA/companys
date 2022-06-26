package com.data.company.jwt.repository.converter;

import com.data.company.jwt.model.Token;
import com.data.company.jwt.repository.entity.TokenEntity;
import org.springframework.stereotype.Component;

@Component
public class TokenConverter {

  public Token convertFromEntity(TokenEntity entity) {
    Token token = new Token();
    token.setToken(entity.getToken());
    token.setDate(entity.getDate());
    token.setEmail(entity.getEmail());
    token.setId(entity.getId());
    return token;
  }

  public TokenEntity convertToEntity(Token token) {
    TokenEntity entity = new TokenEntity();
    entity.setToken(token.getToken());
    entity.setDate(token.getDate());
    entity.setEmail(token.getEmail());
    entity.setId(token.getId());
    return entity;
  }

}
