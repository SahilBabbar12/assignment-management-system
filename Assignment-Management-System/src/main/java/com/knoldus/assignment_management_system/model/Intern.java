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
    private Long employeeId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name="competency_name")
    private String competencyName;
    @Column(name="skills")
    private String skills;
    @Column(name="created_date")
    private LocalDateTime createdDate= LocalDateTime.now();
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate=LocalDateTime.now();



}
