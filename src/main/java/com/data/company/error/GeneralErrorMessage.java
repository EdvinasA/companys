package com.data.company.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;

@JsonInclude(Include.NON_NULL)
@Getter
public class GeneralErrorMessage implements ErrorMessage {

  protected Enum<?> code;
  protected String message;

  public GeneralErrorMessage() {
  }

  public GeneralErrorMessage(String message) {
    this.message = message;
  }
}
