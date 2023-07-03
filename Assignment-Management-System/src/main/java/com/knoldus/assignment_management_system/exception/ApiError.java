package com.knoldus.assignment_management_system.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * Represents an API error response.
 */
@Data
@AllArgsConstructor
public class ApiError {
    private final String errorCode;
    private final HttpStatus status;
    private final LocalDateTime localDateTime;
}
