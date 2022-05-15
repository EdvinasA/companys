package com.data.company.user.repository;

import com.data.company.user.model.User;
import com.data.company.user.repository.converter.UserConverter;
import com.data.company.user.repository.entity.UserEntity;
import com.data.company.user.repository.jpa.UserJpaRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class UserQueryRepository {

  private final UserJpaRepository userJpaRepository;
  private final UserConverter converter;

  @Transactional
  public User getUserByEmail(String email) {
    Optional<UserEntity> optionalEntity = userJpaRepository.findByEmail(email);
    UserEntity entity = optionalEntity.orElse(null);
    if (entity != null) {
      return converter.convertFromEntity(entity);
    }
    return null;
  }

}
