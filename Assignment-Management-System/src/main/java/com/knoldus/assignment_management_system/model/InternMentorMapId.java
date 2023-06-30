package com.knoldus.assignment_management_system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class InternMentorMapId {
    private Integer intern;
    private Integer mentor;
}
