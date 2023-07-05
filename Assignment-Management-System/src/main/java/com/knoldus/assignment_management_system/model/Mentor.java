package com.knoldus.assignment_management_system.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Represents a mentor.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Mentor {

    /**
     * The ID of the mentor.
     */
    @Id
    private Long mentorId;

    /**
     * The employee ID associated with the mentor.
     */
    @Column(name = "emp_id")
    private String empId;

    /**
     * The competency name associated with the mentor.
     */
    @Column(name = "competency_name")
    private String competencyName;

    /**
     * The date and time when the mentor was last modified.
     */
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate = LocalDateTime.now();

    /**
     * The date and time when the mentor was created.
     */
    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

}
