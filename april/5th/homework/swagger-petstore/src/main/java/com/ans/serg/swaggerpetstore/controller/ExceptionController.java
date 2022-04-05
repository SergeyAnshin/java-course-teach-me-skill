package com.ans.serg.swaggerpetstore.controller;

import com.ans.serg.swaggerpetstore.entity.ApiResponse;
import com.ans.serg.swaggerpetstore.exception.PetNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PetNotFoundException.class)
    public ResponseEntity<ApiResponse> handleException(PetNotFoundException ex) {
        return ResponseEntity.ok(new ApiResponse(404, NOT_FOUND.getReasonPhrase(), ex.getMessage()));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.ok(new ApiResponse(405, status.getReasonPhrase(), "Invalid input"));
    }
}
