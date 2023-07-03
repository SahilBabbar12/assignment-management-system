package com.knoldus.assignment_management_system.controller;

import com.knoldus.assignment_management_system.model.Assignment;
import com.knoldus.assignment_management_system.service.serviceimpl.AssignmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * Controller class for handling assignment-related operations.
 */
@RestController
public class AssignmentController {

    private AssignmentServiceImpl assignmentService;

    @Autowired
    public AssignmentController(AssignmentServiceImpl assignmentService) {
        this.assignmentService = assignmentService;
    }

    /**
     * Adds a new assignment.
     *
     * @param assignment the assignment to be added
     * @throws ExecutionException   if an error occurs during execution
     * @throws InterruptedException if the execution is interrupted
     */
    @PostMapping("/adminfirestore")
    public void addAssignment(@RequestBody Assignment assignment) throws ExecutionException, InterruptedException {
        assignmentService.createUser(assignment);
    }
}
