package com.data.company.user.repository.converter;

import com.data.company.user.model.Role;
import com.data.company.user.repository.entity.RoleEntity;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {

  public RoleEntity convertToEntity(Role input) {
    return new RoleEntity()
        .setAuthority(input.getRole());
  }
}
