package com.data.company.user.service;

import com.data.company.user.model.User;
import com.data.company.user.repository.UserQueryRepository;
import java.util.Collection;
import java.util.Collections;
import javax.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserQueryRepository userQueryRepository;

  @SneakyThrows
  @Override
  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String email) throws EntityNotFoundException {
    User user = userQueryRepository.getUserByEmail(email);

    return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), true
        , true, true, true, getAuthorities("USER"));
  }

  private Collection<? extends GrantedAuthority> getAuthorities(String role) {
    return Collections.singletonList(new SimpleGrantedAuthority(role));
  }
}
