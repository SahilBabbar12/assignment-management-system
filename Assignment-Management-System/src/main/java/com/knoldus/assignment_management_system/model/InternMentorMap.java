package com.knoldus.assignment_management_system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

/**
 * Represents a mapping between an intern and a mentor.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@IdClass(InternMentorMapId.class)
public class InternMentorMap {
    /**
     * The ID of the intern.
     */
    @Id
    private Long intern;

    /**
     * The ID of the mentor.
     */
    @Id
    private Long mentor;

    /**
     * The date when the mapping was last modified.
     */
    private LocalDate modifiedDate = LocalDate.now();

    /**
     * The date when the mapping was created.
     */
    private LocalDate createdDate = LocalDate.now();
}
