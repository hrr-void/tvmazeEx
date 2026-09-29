package com.hrr.tvmaze.infrastructure.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidatiionException(HandlerMethodValidationException e){
        ErrorResponse response = new ErrorResponse(400, e.getMessage());
        return ResponseEntity.badRequest().body(response);
    }
}
