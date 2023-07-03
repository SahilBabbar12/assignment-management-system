package com.knoldus.assignment_management_system.exception;

/**
 * Custom exception class for no such element.
 */
public class NoSuchElementException extends RuntimeException {

    /**
     * Constructs a NoSuchElementException with the specified detail message.
     *
     * @param message the detail message
     */
    public NoSuchElementException(String message) {
        super(message);
    }
}