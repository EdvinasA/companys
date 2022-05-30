package com.data.company.user.repository;

import com.data.company.user.model.User;
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

  @Transactional
  public void create(User user) {
    RolesEntity rolesEntity = new RolesEntity();
    rolesEntity.setRole("ADMIN");
    rolesEntity.setId(UUID.randomUUID());
    UserEntity entity = userConverter.convertToEntity(user);
    entity.setRoles(List.of(rolesEntity));
    rolesEntity.setUser(List.of(entity));

    userJpaRepository.save(entity);
  }

}
