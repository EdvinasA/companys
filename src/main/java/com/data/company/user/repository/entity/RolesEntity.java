package com.data.company.user.repository.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import lombok.Data;

//@Data
//public class RolesEntity {
//
//  @Id
//  @GeneratedValue(strategy = GenerationType.SEQUENCE)
//  @Column(name = "id")
//  private Long id;
//
//  @ManyToMany(fetch = FetchType.LAZY)
//  @JoinColumn(name = "users_id")
//  private UserEntity user;
//
//  @Column(name = "role")
//  private String role;
//
//}
