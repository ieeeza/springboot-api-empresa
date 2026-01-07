package com.apispring.demo.exceptions;

import com.apispring.demo.dtos.response.ServiceResponse;
import com.apispring.demo.exceptions.Fields.FieldEmailRequiredException;
import com.apispring.demo.exceptions.Fields.FieldPasswordRequiredException;
import com.apispring.demo.exceptions.User.UserAlreadyExistException;
import com.apispring.demo.exceptions.User.UserDoNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptions extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ServiceResponse<Void>> handleUserAlreadyExistException(UserAlreadyExistException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ServiceResponse.error(exception.getMessage(), HttpStatus.CONFLICT.value()));
    }

    @ExceptionHandler(FieldEmailRequiredException.class)
    public ResponseEntity<ServiceResponse<Void>> handleFieldEmailRequiredException(FieldEmailRequiredException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ServiceResponse.error(exception.getMessage(), HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(FieldPasswordRequiredException.class)
    public ResponseEntity<ServiceResponse<Void>> handleFieldPasswordRequiredException(FieldPasswordRequiredException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ServiceResponse.error(exception.getMessage(), HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(UserDoNotExistException.class)
    public ResponseEntity<ServiceResponse<Void>> handleUserDoNotExistException(UserDoNotExistException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ServiceResponse.error(exception.getMessage(), HttpStatus.NOT_FOUND.value()));
    }
}
