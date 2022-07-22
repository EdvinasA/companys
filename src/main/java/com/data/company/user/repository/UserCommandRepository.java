package com.data.company.user.repository;

import com.data.company.user.model.Role;
import com.data.company.user.model.User;
import com.data.company.user.repository.converter.RoleConverter;
import com.data.company.user.repository.converter.UserConverter;
import com.data.company.user.repository.entity.RolesEntity;
import com.data.company.user.repository.entity.UserEntity;
import com.data.company.user.repository.jpa.UserJpaRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class UserCommandRepository {

  private final UserJpaRepository userJpaRepository;
  private final UserConverter userConverter;
  private final RoleConverter roleConverter;

  @Transactional
  public User create(User user, Role role) {
    RolesEntity rolesEntity = roleConverter.convertToEntity(role);
    rolesEntity.setId(UUID.randomUUID());
    UserEntity entity = userConverter.convertToEntity(user);
    rolesEntity.setUser(List.of(entity));
    entity.setRole(List.of(rolesEntity));

    userJpaRepository.save(entity);

    return userConverter.convertFromEntity(entity);
  }

}
