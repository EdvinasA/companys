package com.data.company.user.service;

import com.data.company.jwt.JwtTokenGenerator;
import com.data.company.user.model.Login;
import com.data.company.user.model.Register;
import com.data.company.user.model.Token;
import com.data.company.user.model.User;
import com.data.company.user.repository.UserCommandRepository;
import com.data.company.user.repository.UserQueryRepository;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

  private final UserQueryRepository queryRepository;
  private final UserCommandRepository commandRepository;
  private final JwtTokenGenerator tokenGenerator;
  private final PasswordEncoder passwordEncoder;

  public Token login(Login loginBody) {
    return tokenGenerator.generateToken(loginBody.getEmail());
  }

  public Token register(Register registerBody) {
    String email = registerBody.getEmail();
    User isUsedEmail = queryRepository.getUserByEmail(email);
    if (isUsedEmail == null) {
      User newUser = new User();
      newUser.setId(UUID.randomUUID());
      newUser.setEmail(email);
      newUser.setFullName(registerBody.getFullName());
      newUser.setPassword(passwordEncoder.encode(registerBody.getPassword()));
      newUser.setRegisteredDate(LocalDate.now());

      commandRepository.create(newUser);

      return tokenGenerator.generateToken(email);
    }
    return null;
  }

}
