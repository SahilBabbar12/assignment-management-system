package com.knoldus.assignment_management_system.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.auditing.CurrentDateTimeProvider;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Mentor {

    @Id
    private Long mentorId;
    @Column(name = "emp_id")
    private String emp_id;
    @Column(name="competency_name")
    private String competency_name;
    @Column(name="modified_date")
    private LocalDateTime modified_date= LocalDateTime.now();
    @Column(name = "created_date")
    private LocalDateTime created_date= LocalDateTime.now();

}