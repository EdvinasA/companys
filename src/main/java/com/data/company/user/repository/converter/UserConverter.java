package com.data.company.user.repository.converter;

import com.data.company.user.model.User;
import com.data.company.user.repository.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

  public User convertFromEntity(UserEntity entity) {
    User user = new User();
    user.setId(entity.getId());
    user.setEmail(entity.getEmail());
    user.setPassword(entity.getPassword());
    user.setRegisteredDate(entity.getRegisteredDate());
    user.setName(entity.getName());
    user.setLastName(entity.getLastName());
    user.setRole(entity.getRole().getAuthority());
    user.setReceiveEmails(entity.isReceiveEmails());
    user.setReceiveEmailsAboutLookedItems(entity.isReceiveEmailsAboutLookedItems());
    user.setReceiveEmailsAboutServiceQuality(entity.isReceiveEmailsAboutServiceQuality());
    user.setReceiveEmailsAboutGivingFeedback(entity.isReceiveEmailsAboutGivingFeedback());

    return user;
  }

  public UserEntity convertToEntity(User user) {
    UserEntity entity = new UserEntity();
    entity.setId(user.getId());
    entity.setEmail(user.getEmail());
    entity.setPassword(user.getPassword());
    entity.setRegisteredDate(user.getRegisteredDate());
    entity.setName(user.getName());
    entity.setLastName(user.getLastName());
    entity.setReceiveEmails(user.isReceiveEmails());
    entity.setReceiveEmailsAboutLookedItems(user.isReceiveEmailsAboutLookedItems());
    entity.setReceiveEmailsAboutServiceQuality(user.isReceiveEmailsAboutServiceQuality());
    entity.setReceiveEmailsAboutGivingFeedback(user.isReceiveEmailsAboutGivingFeedback());

    return entity;
  }
}
