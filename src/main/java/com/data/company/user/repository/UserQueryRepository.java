package com.data.company.user.repository;

import com.data.company.user.model.User;
import com.data.company.user.repository.converter.UserConverter;
import com.data.company.user.repository.entity.UserEntity;
import com.data.company.user.repository.jpa.UserJpaRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserQueryRepository {

  private final UserJpaRepository userJpaRepository;
  private final UserConverter converter;

  public User getUserByEmail(String email) {
    Optional<UserEntity> optionalEntity = userJpaRepository.findByEmail(email);
    UserEntity entity = optionalEntity.orElseThrow(() -> new UsernameNotFoundException("Email not found"));
    return converter.convertFromEntity(entity);
  }

}
