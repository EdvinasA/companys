package com.data.company.user.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.Data;

@Data
public class SubscriptionDetails {

  private boolean receiveEmails;

  @JsonFormat(pattern="yyyy-MM-dd")
  private LocalDate receiveEmailsDate;

  private boolean receiveEmailsAboutLookedItems;

  @JsonFormat(pattern="yyyy-MM-dd")
  private LocalDate receiveEmailsAboutLookedItemsDate;

  private boolean receiveEmailsAboutGivingFeedback;

  @JsonFormat(pattern="yyyy-MM-dd")
  private LocalDate receiveEmailsAboutGivingFeedbackDate;

  private boolean receiveEmailsAboutServiceQuality;

  @JsonFormat(pattern="yyyy-MM-dd")
  private LocalDate receiveEmailsAboutServiceQualityDate;
}
