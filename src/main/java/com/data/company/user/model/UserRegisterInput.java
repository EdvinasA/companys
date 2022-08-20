package com.data.company.user.model;

import lombok.Data;

@Data
public class UserRegisterInput {

	private String email;

	private String name;

	private String lastName;

	private String password;
}
