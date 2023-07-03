package com.knoldus.assignment_management_system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.auditing.CurrentDateTimeProvider;

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
    private CurrentDateTimeProvider modifiedDate;
    private CurrentDateTimeProvider createdDate;

}
