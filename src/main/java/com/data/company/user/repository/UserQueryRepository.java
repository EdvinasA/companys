package com.data.company.user.repository;

import com.data.company.user.model.User;
import com.data.company.user.repository.converter.UserConverter;
import com.data.company.user.repository.entity.UserEntity;
import com.data.company.user.repository.jpa.UserJpaRepository;
import java.util.Optional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class UserQueryRepository {

  private UserJpaRepository userJpaRepository;
  private UserConverter converter;

  public User getUserByEmail(String email) {
    Optional<UserEntity> entity = userJpaRepository.findByEmail(email);
    return entity.map(userEntity -> converter.convertFromEntity(userEntity)).orElseThrow(() -> new UsernameNotFoundException("Email not found"));
  }

}
