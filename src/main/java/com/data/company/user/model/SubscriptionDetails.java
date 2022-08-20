package com.data.company.user.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.Data;

@Data
public class SubscriptionDetails {

	private Long id;

	private Boolean receiveEmails;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate receiveEmailsDate;

	private Boolean receiveEmailsAboutLookedItems;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate receiveEmailsAboutLookedItemsDate;

	private Boolean receiveEmailsAboutGivingFeedback;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate receiveEmailsAboutGivingFeedbackDate;

	private Boolean receiveEmailsAboutServiceQuality;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate receiveEmailsAboutServiceQualityDate;
}
