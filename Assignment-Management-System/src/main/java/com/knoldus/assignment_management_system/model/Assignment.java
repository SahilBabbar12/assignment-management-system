package com.knoldus.assignment_management_system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {
    private String id;
    private String technology;
    private String topic;
    private String createdBy;
    private String assignedTo;
    private List<Questions> questions;


}
