package com.data.company.user.repository.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "subscription_details")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@Column(name = "receive_emails")
	private boolean receiveEmails;

	@Column(name = "receive_emails_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate receiveEmailsDate;

	@Column(name = "receive_emails_about_looked_items")
	private boolean receiveEmailsAboutLookedItems;

	@Column(name = "receive_emails_about_looked_items_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate receiveEmailsAboutLookedItemsDate;

	@Column(name = "receive_emails_about_giving_feedback")
	private boolean receiveEmailsAboutGivingFeedback;

	@Column(name = "receive_emails_about_giving_feedback_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate receiveEmailsAboutGivingFeedbackDate;

	@Column(name = "receive_emails_about_service_quality")
	private boolean receiveEmailsAboutServiceQuality;

	@Column(name = "receive_emails_about_service_quality_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate receiveEmailsAboutServiceQualityDate;
}
