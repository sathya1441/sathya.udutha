package com.learningmodule.spring_boot_application.Exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Object> handleStudentNotFoundException(StudentNotFoundException ex){
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("HTTPStatus", HttpStatus.NOT_FOUND);
        errorResponse.put("ErrorMessage", ex.getMessage());
        return ResponseEntity.status(404).body(errorResponse);
    }
}
