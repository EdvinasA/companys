package com.data.company.exceptions;

public class ProductNotFoundException extends RuntimeException{

  public ProductNotFoundException(String message) {
    super(message);
  }
}
