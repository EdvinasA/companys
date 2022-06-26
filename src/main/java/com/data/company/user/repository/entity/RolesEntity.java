package com.data.company.user.repository.entity;

import com.data.company.user.model.Authority;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
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

  @OneToOne(fetch = FetchType.LAZY)
  private UserEntity user;

  @Column(name = "role")
  @Enumerated(value = EnumType.STRING)
  private Authority authority;

}
