package com.knoldus.assignment_management_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<Object> handleEmptyInput(EmptyInputException emptyInputException){
        return new ResponseEntity<>(new ApiError(emptyInputException.getMessage(),HttpStatus.BAD_REQUEST, LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException elementException){
        return new ResponseEntity<>(new ApiError(elementException.getMessage(), HttpStatus.NOT_FOUND,LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }
}
