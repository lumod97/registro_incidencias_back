package com.cpiura.catics.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        ex.printStackTrace(); // Imprime el error en la consola
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno: " + ex.getMessage());
    }
}
