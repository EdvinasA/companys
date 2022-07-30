package com.data.company.user.repository.converter;

import com.data.company.user.model.SubscriptionDetails;
import com.data.company.user.repository.entity.SubscriptionDetailsEntity;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionDetailsConverter {

  public SubscriptionDetails convertFromEntity(SubscriptionDetailsEntity entity) {
    return new SubscriptionDetails()
        .setId(entity.getId())
        .setReceiveEmails(entity.isReceiveEmails())
        .setReceiveEmailsDate(entity.getReceiveEmailsDate())
        .setReceiveEmailsAboutGivingFeedback(entity.isReceiveEmailsAboutGivingFeedback())
        .setReceiveEmailsAboutGivingFeedbackDate(entity.getReceiveEmailsAboutGivingFeedbackDate())
        .setReceiveEmailsAboutLookedItems(entity.isReceiveEmailsAboutLookedItems())
        .setReceiveEmailsAboutLookedItemsDate(entity.getReceiveEmailsAboutLookedItemsDate())
        .setReceiveEmailsAboutServiceQuality(entity.isReceiveEmailsAboutServiceQuality())
        .setReceiveEmailsAboutServiceQualityDate(entity.getReceiveEmailsAboutServiceQualityDate());
  }

  public SubscriptionDetailsEntity convertToEntity(SubscriptionDetails subscriptionDetails) {
    return new SubscriptionDetailsEntity()
        .setId(subscriptionDetails.getId())
        .setReceiveEmails(subscriptionDetails.isReceiveEmails())
        .setReceiveEmailsDate(subscriptionDetails.getReceiveEmailsDate())
        .setReceiveEmailsAboutGivingFeedback(subscriptionDetails.isReceiveEmailsAboutGivingFeedback())
        .setReceiveEmailsAboutGivingFeedbackDate(subscriptionDetails.getReceiveEmailsAboutGivingFeedbackDate())
        .setReceiveEmailsAboutLookedItems(subscriptionDetails.isReceiveEmailsAboutLookedItems())
        .setReceiveEmailsAboutLookedItemsDate(subscriptionDetails.getReceiveEmailsAboutLookedItemsDate())
        .setReceiveEmailsAboutServiceQuality(subscriptionDetails.isReceiveEmailsAboutServiceQuality())
        .setReceiveEmailsAboutServiceQualityDate(subscriptionDetails.getReceiveEmailsAboutServiceQualityDate());
  }
}
