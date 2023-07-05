package com.knoldus.assignment_management_system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents the composite ID for the InternMentorMap class.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InternMentorMapId {
    /**
     * The ID of the intern.
     */
    private Long intern;

    /**
     * The ID of the mentor.
     */
    private Long mentor;
}
