package com.example.paymentservice.exceptions;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WrongPaymentException.class)
    public ResponseEntity<Map<String, Object>> handleWrongPayment(WrongPaymentException ex) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR, "WRONG_PAYMENT", ex.getMessage());
    }

    private ResponseEntity<Map<String, Object>> error(HttpStatus status, String errorCode, String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", Instant.now().toString());
        body.put("status", status.value());
        body.put("error_code", errorCode);
        body.put("message", message);
        return ResponseEntity.status(status).body(body);
    }
}
