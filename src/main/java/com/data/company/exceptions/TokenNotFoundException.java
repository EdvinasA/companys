package com.data.company.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TokenNotFoundException extends RuntimeException {

	public TokenNotFoundException(String message) {
		super(message);
	}
}
