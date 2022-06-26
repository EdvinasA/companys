package com.data.company.configuration;

import com.data.company.error.GeneralErrorMessage;
import com.data.company.exceptions.PasswordNotMatchingException;
import com.data.company.exceptions.ProductNotFoundException;
import com.data.company.exceptions.RegisteredEmailFoundException;
import com.data.company.exceptions.TokenNotFoundException;
import javax.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(TokenNotFoundException.class)
  public ResponseEntity<GeneralErrorMessage> handleTokenNotFoundException(TokenNotFoundException exc) {
    log.error("User not validated, can't access without being valid.");
    GeneralErrorMessage message = new GeneralErrorMessage(exc.getMessage());

    return buildResponseEntity(HttpStatus.FORBIDDEN, message);
  }

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<GeneralErrorMessage> handleUsernameNotFoundException(EntityNotFoundException ex) {
    log.error("Email not found.");
    GeneralErrorMessage message = new GeneralErrorMessage(ex.getMessage());

    return buildResponseEntity(HttpStatus.BAD_REQUEST, message);
  }

  @ExceptionHandler(PasswordNotMatchingException.class)
  public ResponseEntity<GeneralErrorMessage> handlePasswordNotMatchingException(PasswordNotMatchingException ex) {
    log.error("Password in database does not match the given.");
    GeneralErrorMessage message = new GeneralErrorMessage(ex.getMessage());

    return buildResponseEntity(HttpStatus.BAD_REQUEST, message);
  }

  @ExceptionHandler(ProductNotFoundException.class)
  public ResponseEntity<GeneralErrorMessage> handleProductNotFoundException(ProductNotFoundException ex) {
    log.error("Product not found.");
    GeneralErrorMessage message = new GeneralErrorMessage("Product not found.");

    return buildResponseEntity(HttpStatus.BAD_REQUEST, message);
  }

  @ExceptionHandler(RegisteredEmailFoundException.class)
  public ResponseEntity<GeneralErrorMessage> handleRegisteredEmailFoundException(RegisteredEmailFoundException ex) {
    log.error("Registered email already in use.");
    GeneralErrorMessage message = new GeneralErrorMessage(ex.getMessage());

    return buildResponseEntity(HttpStatus.BAD_REQUEST, message);
  }

  private <T> ResponseEntity<T> buildResponseEntity(HttpStatus status, T body) {
    return ResponseEntity.status(status).body(body);
  }
}
