package com.data.company.user.repository.entity;

import com.data.company.user.model.Authority;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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

  @ManyToMany(fetch = FetchType.LAZY,
      cascade = {
          CascadeType.PERSIST,
          CascadeType.MERGE
      }, mappedBy = "role")
  @JsonIgnore
  private List<UserEntity> user = new ArrayList<>();

  @Column(name = "role")
  @Enumerated(value = EnumType.STRING)
  private Authority authority;

}
