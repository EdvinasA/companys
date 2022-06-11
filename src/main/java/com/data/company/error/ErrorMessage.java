package com.data.company.error;

public interface ErrorMessage {

  Enum<?> getCode();

  String getMessage();
}
