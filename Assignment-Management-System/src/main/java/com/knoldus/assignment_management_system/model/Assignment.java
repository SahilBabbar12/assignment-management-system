package com.knoldus.assignment_management_system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {
    private String Id;
    private String technology;
    private String topic;
    private String created_by;
    private String assigned_to;
    private List<Question> questions;


}
