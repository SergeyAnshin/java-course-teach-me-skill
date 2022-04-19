package com.ans.serg.restsecurity.controller;

import com.ans.serg.restsecurity.exception.EntityAlreadyExistsException;
import com.ans.serg.restsecurity.exception.EntityNotFoundException;
import com.ans.serg.restsecurity.exception.InvalidJWTException;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(InvalidJWTException.class)
    public ResponseEntity<Object> invalidJWTException(InvalidJWTException exception) {
        return new ResponseEntity("", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<Object> expiredJwtException(ExpiredJwtException exception) {
        return new ResponseEntity("", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Object> authenticationException(AuthenticationException exception) {
        return new ResponseEntity("auth ex", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<Object> entityAlreadyExistsException(EntityAlreadyExistsException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> entityNotFoundException(EntityNotFoundException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
