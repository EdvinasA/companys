package com.data.company.user.model;

import java.util.UUID;
import lombok.Data;

@Data
public class UserUpdateInput {

  private UUID id;

  private String name;

  private String lastName;

  private String password;

  private boolean receiveEmails;

  private boolean receiveEmailsAboutLookedItems;

  private boolean receiveEmailsAboutGivingFeedback;

  private boolean receiveEmailsAboutServiceQuality;

  private Authority role;
}
