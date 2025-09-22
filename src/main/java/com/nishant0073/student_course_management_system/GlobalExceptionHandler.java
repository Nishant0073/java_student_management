package com.nishant0073.student_course_management_system;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nishant0073.student_course_management_system.Model.ApiError;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiError> handleRuntimeException(RuntimeException ex){
        ApiError apiError = new ApiError(ex.getMessage(),"Something went wrong while processing your request", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiError> handleEntityNotFoundException(EntityNotFoundException ex){
        ApiError apiError = new ApiError(ex.getMessage(),"The requested entity not found", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGenral(Exception ex){
        ApiError apiError = new ApiError(ex.getMessage(),"Intenal server error", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
