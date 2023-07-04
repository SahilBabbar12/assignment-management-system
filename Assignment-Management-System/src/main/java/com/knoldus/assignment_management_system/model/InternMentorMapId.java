package com.knoldus.assignment_management_system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InternMentorMapId {
    private Long intern;
    private Long mentor;
}
