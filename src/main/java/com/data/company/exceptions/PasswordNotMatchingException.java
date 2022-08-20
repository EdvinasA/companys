package com.data.company.exceptions;

public class PasswordNotMatchingException extends RuntimeException {

	public PasswordNotMatchingException(String message) {
		super(message);
	}
}
