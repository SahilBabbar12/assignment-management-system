package com.knoldus.assignment_management_system.model;

import jakarta.persistence.Column;

import java.time.LocalDateTime;
import java.util.List;

public class Mentor_assignment {
    private Long mentorId;
    private String emp_id;
    private String competency_name;
    private LocalDateTime modified_date= LocalDateTime.now();
    private LocalDateTime created_date= LocalDateTime.now();

    private String Id;
    private String technology;
    private String topic;
    private String created_by;
    private String assigned_to;
    private List<Question> questions;
}
