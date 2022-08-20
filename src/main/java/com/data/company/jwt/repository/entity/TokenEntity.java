package com.data.company.jwt.repository.entity;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "token")
@AllArgsConstructor
@NoArgsConstructor
public class TokenEntity {

	@Id
	private UUID id;

	@Column(name = "token")
	private String token;

	@Column(name = "email")
	private String email;

	@Column(name = "date")
	private Date date;

}
