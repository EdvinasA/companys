package com.data.company.user.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "role")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "role")
  private String authority;

}
