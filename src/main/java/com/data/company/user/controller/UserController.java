package com.data.company.user.controller;

import com.data.company.jwt.JwtTokenGenerator;
import com.data.company.user.model.UserLoginInput;
import com.data.company.user.model.UserRegisterInput;
import com.data.company.user.model.User;
import com.data.company.user.repository.UserQueryRepository;
import com.data.company.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Slf4j
public class UserController {

  private final UserService userService;
  private final UserQueryRepository queryRepository;
  private final JwtTokenGenerator tokenProvider;
  private final PasswordEncoder passwordEncoder;

  @PostMapping("/login")
  public ResponseEntity<User> login(@RequestBody UserLoginInput userLoginInputBody) {
    User user = queryRepository.getUserByEmail(userLoginInputBody.getEmail());

    if (userLoginInputBody.getEmail().equals(user.getEmail()) && passwordEncoder
        .matches(userLoginInputBody.getPassword(), user.getPassword())) {

      return ResponseEntity.ok(userService.login(userLoginInputBody, user));
    }
    return ResponseEntity.badRequest().body(null);
  }

  @PostMapping("/register")
  public ResponseEntity<User> register(@RequestBody UserRegisterInput userRegisterInputBody) {
    if (queryRepository.getUserByEmail(userRegisterInputBody.getEmail()) == null) {

      return ResponseEntity.ok(userService.register(userRegisterInputBody));
    }

    return ResponseEntity.badRequest().body(null);
  }

  @GetMapping("{token}")
  public ResponseEntity<User> getUserByToken(@PathVariable String token) throws NotFoundException {
    if (tokenProvider.validateToken(token)) {

      return ResponseEntity.ok(userService.validateToken(token));
    }

    return ResponseEntity.ok(null);
  }


}
