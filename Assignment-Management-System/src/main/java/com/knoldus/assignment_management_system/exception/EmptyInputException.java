package com.knoldus.assignment_management_system.exception;

/**
 * Custom exception class for empty input.
 */
public class EmptyInputException extends RuntimeException {

    /**
     * Constructs an EmptyInputException with the specified detail message.
     *
     * @param message the detail message
     */
    public EmptyInputException(String message) {
        super(message);
    }
}