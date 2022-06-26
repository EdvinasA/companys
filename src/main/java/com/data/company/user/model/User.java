package com.data.company.user.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class User {

  private UUID id;

  private String email;

  private String name;

  private String lastName;

  private String password;

  private Token token;

  @JsonFormat(pattern="yyyy-MM-dd")
  private LocalDate registeredDate;

  private Authority role;

}
