package com.knoldus.assignment_management_system.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Intern {

    @Id
    @Column(name="intern_id")
    private Long id;
    @Column(name = "employee_id")
    private Long employee_id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name="competency_name")
    private String competency_name;
    @Column(name="skills")
    private String skills;
    @Column(name="created_date")
    private LocalDateTime created_date= LocalDateTime.now();
    @Column(name = "modified_date")
    private LocalDateTime modified_date=LocalDateTime.now();



}
