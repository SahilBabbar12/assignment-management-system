package com.knoldus.assignment_management_system.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents a question.
 */
@Data
@AllArgsConstructor
public class Questions {
    /**
     * The ID of the question.
     */
    private Long id;

    /**
     * The question text.
     */
    private String question;
}
