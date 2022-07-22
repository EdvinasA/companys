package com.data.company.user.repository.converter;

import com.data.company.user.model.Role;
import com.data.company.user.repository.entity.RolesEntity;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {

  public RolesEntity convertToEntity(Role input) {
    return new RolesEntity()
        .setId(input.getId())
        .setAuthority(input.getRole());
  }
}
