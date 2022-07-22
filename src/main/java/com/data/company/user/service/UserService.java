package com.data.company.user.service;

import com.data.company.exceptions.PasswordNotMatchingException;
import com.data.company.exceptions.RegisteredEmailFoundException;
import com.data.company.exceptions.TokenNotFoundException;
import com.data.company.jwt.JwtTokenGenerator;
import com.data.company.jwt.repository.entity.TokenEntity;
import com.data.company.jwt.repository.jpa.TokenJpaRepository;
import com.data.company.user.model.Authority;
import com.data.company.user.model.Role;
import com.data.company.user.model.UserLoginInput;
import com.data.company.user.model.UserRegisterInput;
import com.data.company.user.model.User;
import com.data.company.user.repository.UserCommandRepository;
import com.data.company.user.repository.UserQueryRepository;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
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

  public User login(UserLoginInput userLoginInputBody) {
    User user = checkIfUserLoginIsValid(userLoginInputBody);
    return user
        .setToken(tokenGenerator.generateToken(userLoginInputBody.getEmail()));
  }

  public User register(UserRegisterInput userRegisterInputBody) {
    String email = userRegisterInputBody.getEmail();

    checkIfEmailExists(email);

    User newUser = new User()
        .setId(UUID.randomUUID())
        .setEmail(email)
        .setName(userRegisterInputBody.getName())
        .setLastName(userRegisterInputBody.getLastName())
        .setPassword(passwordEncoder.encode(userRegisterInputBody.getPassword()))
        .setRegisteredDate(LocalDate.now());

    Role role = new Role()
        .setRole(Authority.USER);

    User user = commandRepository.create(newUser, role);
    newUser.setToken(tokenGenerator.generateToken(email));

    return user;
  }

  public User validateToken(String token) {
    Optional<TokenEntity> entityOptional = tokenJpaRepository.findDistinctByToken(token);
    TokenEntity entity = entityOptional.orElseThrow(TokenNotFoundException::new);

    User user = queryRepository.getUserByEmail(entity.getEmail());
    user.setToken(entity.getToken());

    return user;
  }

  private void checkIfEmailExists(String input) {
    if (queryRepository.findUserByEmail(input) != null) {
      throw new RegisteredEmailFoundException(String.format("Email %s already in use.", input));
    }
  }

  private User checkIfUserLoginIsValid(UserLoginInput userLoginInput) {
    User user = queryRepository.getUserByEmail(userLoginInput.getEmail());

    if (userLoginInput.getEmail().equals(user.getEmail()) && passwordEncoder
        .matches(userLoginInput.getPassword(), user.getPassword())) {
      return user;

    } else {
      throw new PasswordNotMatchingException(
          String.format("User with email %s password does not match", userLoginInput.getEmail()));
    }
  }

}
