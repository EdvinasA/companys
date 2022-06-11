package com.data.company.exceptions;

public class RegisteredEmailFoundException extends RuntimeException{

  public RegisteredEmailFoundException(String message) {
    super(message);
  }
}
