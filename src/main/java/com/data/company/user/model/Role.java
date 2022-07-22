package com.data.company.user.model;

import java.util.UUID;
import lombok.Data;

@Data
public class Role {

  private UUID id;
  private User user;
  private Authority role;

}
