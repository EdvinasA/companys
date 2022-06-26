package com.data.company.user.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Authority {

  USER("USER"),
  ADMIN("ADMIN");

  private final String authority;

  Authority(String authority) {
    this.authority = authority;
  }

  @JsonValue
  public String getAuthority() {
    return authority;
  }
}

