package com.knoldus.assignment_management_system.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Represents an intern.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Intern {
    /**
     * The ID of the intern.
     */
    @Id
    @Column(name = "intern_id")
    private Long id;

    /**
     * The employee ID associated with the intern.
     */
    @Column(name = "employee_id")
    private Long employeeId;

    /**
     * The first name of the intern.
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * The last name of the intern.
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * The competency name associated with the intern.
     */
    @Column(name = "competency_name")
    private String competencyName;

    /**
     * The skills of the intern.
     */
    @Column(name = "skills")
    private String skills;

    /**
     * The date and time when the intern was created.
     */
    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

    /**
     * The date and time when the intern was last modified.
     */
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate = LocalDateTime.now();
}
