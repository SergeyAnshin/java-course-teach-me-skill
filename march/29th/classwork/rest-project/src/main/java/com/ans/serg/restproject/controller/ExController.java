package com.ans.serg.restproject.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExController extends ResponseEntityExceptionHandler {

//    First

//    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
//    public ResponseEntity<Object> handleException(RuntimeException ex) {
//        return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//    }

//    Second

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        return super.handleMethodArgumentNotValid(ex, headers, status, request);
//    }
}
