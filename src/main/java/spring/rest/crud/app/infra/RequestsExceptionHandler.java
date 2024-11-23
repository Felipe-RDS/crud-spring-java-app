package spring.rest.crud.app.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RequestsExceptionHandler {

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<RequestsException> handleEntityNotFound(EntityNotFoundException ex) {
    RequestsException response = new RequestsException("Dado não encontrado");
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }
}
