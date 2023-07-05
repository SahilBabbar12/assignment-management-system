package com.knoldus.assignment_management_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

/**
 * Global exception handler for the application.
 */
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handles EmptyInputException and
     * returns a ResponseEntity with an ApiError.
     *
     * @param emptyInputException the EmptyInputException to handle
     * @return a ResponseEntity with an ApiError and HttpStatus.BAD_REQUEST
     */
    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<Object> handleEmptyInput(
            final EmptyInputException emptyInputException) {
        return new ResponseEntity<>(new ApiError(emptyInputException
                .getMessage(),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now()),
                HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles NoSuchElementException
     * and returns a ResponseEntity with an ApiError.
     *
     * @param elementException the NoSuchElementException to handle
     * @return a ResponseEntity with an ApiError and HttpStatus.NOT_FOUND
     */
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(
            final NoSuchElementException elementException) {
        return new ResponseEntity<>(new ApiError(elementException
                .getMessage(),
                HttpStatus.NOT_FOUND,
                LocalDateTime.now()),
                HttpStatus.NOT_FOUND);
    }
}
