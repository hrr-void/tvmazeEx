package com.hrr.tvmaze.infrastructure.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidatiionException(HandlerMethodValidationException e){
        ErrorResponse response = new ErrorResponse(400, "Bad request");
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<ErrorResponse> handleNotFound(HttpClientErrorException.NotFound e){
        ErrorResponse response = new ErrorResponse(404, "Not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
