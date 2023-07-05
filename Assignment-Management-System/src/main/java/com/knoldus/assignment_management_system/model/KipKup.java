package com.knoldus.assignment_management_system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Represents a KipKup session.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class KipKup {

    /**
     * The ID of the session.
     */
    @Id
    private Long sessionId;

    /**
     * The time of the session.
     */
    private LocalTime time;

    /**
     * The name of the mentor for the session.
     */
    private String mentorName;

    /**
     * The date of the session.
     */
    private LocalDate date;

    /**
     * The type of the session.
     */
    private String type;

    /**
     * The topic of the session.
     */
    private String topic;

}
