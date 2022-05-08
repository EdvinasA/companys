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

    return user;
  }

  public UserEntity convertToEntity(User entity) {
    UserEntity user = new UserEntity();
    user.setId(entity.getId());
    user.setEmail(entity.getEmail());
    user.setPassword(entity.getPassword());
    user.setRegisteredDate(entity.getRegisteredDate());
    user.setName(entity.getName());

    return user;
  }
}
