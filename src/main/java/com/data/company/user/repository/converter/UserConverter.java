package com.data.company.user.repository.converter;

import com.data.company.user.model.User;
import com.data.company.user.repository.entity.RolesEntity;
import com.data.company.user.repository.entity.UserEntity;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

  public User convertFromEntity(UserEntity entity) {
    return new User()
        .setId(entity.getId())
        .setEmail(entity.getEmail())
        .setPassword(entity.getPassword())
        .setRegisteredDate(entity.getRegisteredDate())
        .setName(entity.getName())
        .setLastName(entity.getLastName())
        .setRole(entity.getRole()
            .stream()
            .map(RolesEntity::getAuthority)
            .collect(Collectors.toList()));
  }

  public UserEntity convertToEntity(User user) {
    return new UserEntity()
        .setId(user.getId())
        .setEmail(user.getEmail())
        .setPassword(user.getPassword())
        .setRegisteredDate(user.getRegisteredDate())
        .setName(user.getName())
        .setLastName(user.getLastName());
  }
}
