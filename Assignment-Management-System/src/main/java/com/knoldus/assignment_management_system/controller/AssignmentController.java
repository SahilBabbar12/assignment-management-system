package com.knoldus.assignment_management_system.controller;

import com.knoldus.assignment_management_system.model.Assignment;
import com.knoldus.assignment_management_system.service.serviceimpl.AssignmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class AssignmentController {

    private AssignmentServiceImpl assignmentService;

    @Autowired
    public AssignmentController(AssignmentServiceImpl assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping("/adminfirestore")
    public void addAssignment(@RequestBody Assignment assignment) throws ExecutionException, InterruptedException{
       assignmentService .createUser(assignment);
    }
}
