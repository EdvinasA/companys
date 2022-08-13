package com.data.company.user.repository.converter;

import com.data.company.user.model.User;
import com.data.company.user.repository.entity.RoleEntity;
import com.data.company.user.repository.entity.UserEntity;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserConverter {

  private final DeliveryInformationConverter deliveryInformationConverter;

  public User convertFromEntity(UserEntity entity) {
    return new User()
        .setId(entity.getId())
        .setEmail(entity.getEmail())
        .setPassword(entity.getPassword())
        .setRegisteredDate(entity.getRegisteredDate())
        .setName(entity.getName())
        .setLastName(entity.getLastName())
        .setRoles(entity.getRoles())
        .setDeliveryInformationList(entity.getDeliveryInformationList()
            .stream()
            .map(deliveryInformationConverter::convertFromEntity)
            .collect(Collectors.toList()));
  }

  public UserEntity convertToEntity(User user) {
    return new UserEntity()
        .setId(user.getId())
        .setEmail(user.getEmail())
        .setPassword(user.getPassword())
        .setRegisteredDate(user.getRegisteredDate())
        .setName(user.getName())
        .setLastName(user.getLastName())
        .setRoles(user.getRoles());
  }
}
