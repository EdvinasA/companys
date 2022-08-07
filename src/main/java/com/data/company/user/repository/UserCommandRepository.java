package com.data.company.user.repository;

import com.data.company.user.model.Role;
import com.data.company.user.model.SubscriptionDetails;
import com.data.company.user.model.User;
import com.data.company.user.repository.converter.RoleConverter;
import com.data.company.user.repository.converter.SubscriptionDetailsConverter;
import com.data.company.user.repository.converter.UserConverter;
import com.data.company.user.repository.entity.RolesEntity;
import com.data.company.user.repository.entity.SubscriptionDetailsEntity;
import com.data.company.user.repository.entity.UserEntity;
import com.data.company.user.repository.jpa.SubscriptionDetailsJpaRepository;
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
  private final SubscriptionDetailsJpaRepository subscriptionDetailsJpaRepository;
  private final SubscriptionDetailsConverter subscriptionDetailsConverter;
  private final UserConverter userConverter;
  private final RoleConverter roleConverter;

  @Transactional
  public User create(User user, Role role, SubscriptionDetails subscriptionDetails) {
    RolesEntity rolesEntity = roleConverter.convertToEntity(role);
    UserEntity entity = userConverter.convertToEntity(user);
    SubscriptionDetailsEntity subscriptionDetailsEntity = subscriptionDetailsConverter.convertToEntity(subscriptionDetails);
    rolesEntity.setId(UUID.randomUUID());
    subscriptionDetailsEntity.setUser(entity);
    rolesEntity.setUser(List.of(entity));
    entity.setRole(List.of(rolesEntity));

    userJpaRepository.save(entity);
    subscriptionDetailsJpaRepository.save(subscriptionDetailsEntity);

    return userConverter.convertFromEntity(entity);
  }

  @Transactional
  public void update(User user) {
    UserEntity userEntity = userConverter.convertToEntity(user);
    SubscriptionDetailsEntity subscriptionDetailsEntity =
        subscriptionDetailsConverter.convertToEntity(user.getSubscriptionDetails());
    subscriptionDetailsEntity.setUser(userEntity);

    userJpaRepository.save(userEntity);
    subscriptionDetailsJpaRepository.save(subscriptionDetailsEntity);
  }

}
