package com.knoldus.assignment_management_system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents an assignment.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {
    /**
     * The ID of the assignment.
     */
    private String id;

    /**
     * The technology associated with the assignment.
     */
    private String technology;

    /**
     * The topic of the assignment.
     */
    private String topic;

    /**
     * The user who created the assignment.
     */
    private String createdBy;

    /**
     * The user to whom the assignment is assigned.
     */
    private String assignedTo;

    /**
     * The list of questions in the assignment.
     */
    private List<Questions> questions;
}
