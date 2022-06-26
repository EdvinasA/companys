package com.data.company.user.repository;

import com.data.company.user.model.Authority;
import com.data.company.user.model.User;
import com.data.company.user.repository.converter.UserConverter;
import com.data.company.user.repository.entity.RolesEntity;
import com.data.company.user.repository.entity.UserEntity;
import com.data.company.user.repository.jpa.UserJpaRepository;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class UserCommandRepository {

  private final UserJpaRepository userJpaRepository;
  private final UserConverter userConverter;

  @Transactional
  public User create(User user) {
    RolesEntity rolesEntity = new RolesEntity();
    rolesEntity.setAuthority(Authority.USER);
    rolesEntity.setId(UUID.randomUUID());
    UserEntity entity = userConverter.convertToEntity(user);
    entity.setRole(rolesEntity);
    rolesEntity.setUser(entity);

    userJpaRepository.save(entity);

    return userConverter.convertFromEntity(entity);
  }

}
