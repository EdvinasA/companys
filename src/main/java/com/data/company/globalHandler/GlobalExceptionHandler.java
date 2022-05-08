package com.data.company.globalHandler;

import com.data.company.exceptions.TokenNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(TokenNotFoundException.class)
  public ResponseEntity<String> handleTokenNotFoundException(TokenNotFoundException exc) {
    log.error("User not validated, can't access without being valid.");
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body("User not validated, can't access without being valid.");
  }
}
