package com.knoldus.assignment_management_system.service.serviceimpl;

import com.knoldus.assignment_management_system.model.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class AssignmentServiceImpl {

    private final FireStoreService fireStoreService;

    @Autowired
    public AssignmentServiceImpl(FireStoreService fireStoreService) {
        this.fireStoreService = fireStoreService;

    }

    public void createUser(Assignment assignment) throws ExecutionException, InterruptedException {
        fireStoreService.addUser(assignment);
    }
}