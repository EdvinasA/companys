package com.data.company.user.repository.entity;

import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "roles")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RolesEntity {

  @Id
  @Column(name = "id")
  private UUID id;

  @ManyToMany(mappedBy = "roles")
  private List<UserEntity> user;

  @Column(name = "role")
  private String role;

}
