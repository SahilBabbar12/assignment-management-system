package com.knoldus.assignment_management_system.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiError {
    private final String errorCode;
    private final HttpStatus status;
    private final LocalDateTime localDateTime;

}
