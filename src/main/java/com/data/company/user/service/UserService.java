package com.data.company.user.service;

import com.data.company.jwt.JwtTokenGenerator;
import com.data.company.jwt.model.TokenEntity;
import com.data.company.jwt.repository.TokenJpaRepository;
import com.data.company.user.model.Token;
import com.data.company.user.model.UserLoginInput;
import com.data.company.user.model.UserRegisterInput;
import com.data.company.user.model.User;
import com.data.company.user.repository.UserCommandRepository;
import com.data.company.user.repository.UserQueryRepository;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

  private final UserQueryRepository queryRepository;
  private final TokenJpaRepository tokenJpaRepository;
  private final UserCommandRepository commandRepository;
  private final JwtTokenGenerator tokenGenerator;
  private final PasswordEncoder passwordEncoder;

  public User login(UserLoginInput userLoginInputBody, User user) {
    User loginUser = new User();
    loginUser.setEmail(userLoginInputBody.getEmail());
    loginUser.setToken(tokenGenerator.generateToken(userLoginInputBody.getEmail()));
    loginUser.setFullName(user.getFullName());
    loginUser.setRegisteredDate(user.getRegisteredDate());
    return loginUser;
  }

  public User register(UserRegisterInput userRegisterInputBody) {
    String email = userRegisterInputBody.getEmail();

    User newUser = new User();
    newUser.setId(UUID.randomUUID());
    newUser.setEmail(email);
    newUser.setFullName(userRegisterInputBody.getFullName());
    newUser.setPassword(passwordEncoder.encode(userRegisterInputBody.getPassword()));
    newUser.setRegisteredDate(LocalDate.now());
    newUser.setToken(tokenGenerator.generateToken(email));

    commandRepository.create(newUser);

    return newUser;
  }

  public User validateToken(String token) throws NotFoundException {
    Optional<TokenEntity> entityOptional = tokenJpaRepository.findDistinctByToken(token);
    TokenEntity entity = entityOptional.orElseThrow(NotFoundException::new);
    User user = queryRepository.getUserByEmail(entity.getEmail());
    user.setToken(new Token(entity.getToken()));

    return user;
  }

}
