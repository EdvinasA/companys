package com.data.company.user.controller;

import com.data.company.user.model.Login;
import com.data.company.user.model.Register;
import com.data.company.user.model.Token;
import com.data.company.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

  @PostMapping("/login")
  public Token login(@RequestBody Login loginBody) {
    return userService.login(loginBody);
  }

  @PostMapping("/register")
  public Token register(@RequestBody Register registerBody) {
    return userService.register(registerBody);
  }


}
