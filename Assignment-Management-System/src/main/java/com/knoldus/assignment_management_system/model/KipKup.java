package com.knoldus.assignment_management_system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class KipKup {

    @Id
    private Long sessionId;
    private LocalTime time;

    private String mentorName;
    private LocalDate date;

    private String type;

    private String topic;

}