package com.data.company.user.controller;

import com.data.company.user.model.UserLoginInput;
import com.data.company.user.model.UserRegisterInput;
import com.data.company.user.model.User;
import com.data.company.user.model.UserUpdateInput;
import com.data.company.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Slf4j
public class UserController {

  private final UserService userService;

  @PostMapping("/login")
  public ResponseEntity<User> login(@RequestBody UserLoginInput userLoginInputBody) {
    log.info("Checking if user provided valid credentials for email {}",
        userLoginInputBody.getEmail());
    return ResponseEntity.ok(userService.login(userLoginInputBody));
  }

  @PostMapping("/register")
  public ResponseEntity<User> register(@RequestBody UserRegisterInput userRegisterInputBody) {
    log.info("Checking if user provided valid credentials for email {}",
        userRegisterInputBody.getEmail());
    return ResponseEntity.ok(userService.register(userRegisterInputBody));
  }

  @GetMapping("{token}")
  public ResponseEntity<User> getUserByToken(@PathVariable String token) {
    return ResponseEntity.ok(userService.validateToken(token));
  }

  @PutMapping
  public ResponseEntity<Void> updateUserInformation(@RequestBody UserUpdateInput input) {

    return ResponseEntity.ok(null);
  }


}
