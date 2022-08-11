package com.data.company.user.model;

import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class UserUpdateInput {

  private UUID id;

  private String name;

  private String lastName;

  private String password;

  private SubscriptionDetails subscriptionDetails;

  private List<String> role;
}
