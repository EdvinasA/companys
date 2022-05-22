package com.data.company.user.repository.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "users")
public class UserEntity {

  @Id
  private UUID id;

  @Column(name = "email")
  private String email;

  @Column(name = "name")
  private String fullName;

  @Column(name = "password")
  private String password;

  @Column(name = "registered_date")
  @JsonFormat(pattern="yyyy-MM-dd")
  private LocalDate registeredDate;

}
