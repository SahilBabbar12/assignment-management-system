package com.knoldus.assignment_management_system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@IdClass(InternMentorMapId.class)
public class InternMentorMap {

    @Id
    private Long intern;

    @Id
    private Long mentor;

    private LocalDate modified_date= LocalDate.now();

    private LocalDate created_date= LocalDate.now();

}
