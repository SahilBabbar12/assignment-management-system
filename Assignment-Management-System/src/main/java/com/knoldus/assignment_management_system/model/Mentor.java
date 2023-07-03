package com.knoldus.assignment_management_system.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Mentor {

    @Id
    private Long mentorId;
    @Column(name = "emp_id")
    private String empId;
    @Column(name="competency_name")
    private String competencyName;
    @Column(name="modified_date")
    private LocalDateTime modifiedDate= LocalDateTime.now();
    @Column(name = "created_date")
    private LocalDateTime createdDate= LocalDateTime.now();

}