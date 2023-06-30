package com.knoldus.assignment_management_system.service.serviceimpl;

import com.knoldus.assignment_management_system.dao.AssignmentRepository;
import com.knoldus.assignment_management_system.model.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class AssignmentServiceImpl {

    private final FireStoreService fireStoreService;
    private final AssignmentRepository assignmentRepository;

    @Autowired
    public AssignmentServiceImpl(FireStoreService fireStoreService, AssignmentRepository assignmentRepository) {
        this.fireStoreService = fireStoreService;
        this.assignmentRepository = assignmentRepository;
    }

    public void createUser(Assignment assignment) throws ExecutionException, InterruptedException {
        fireStoreService.addUser(assignment);
    }
}