package com.data.company.user.model;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Data;

@Data
public class User {

  private UUID id;

  private String email;

  private String name;

  private String password;

  private LocalDate registeredDate;

}
