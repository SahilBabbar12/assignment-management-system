package com.knoldus.assignment_management_system.service.serviceimpl;

import com.knoldus.assignment_management_system.model.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

/**
 * Service implementation class for managing assignments.
 */
@Service
public class AssignmentServiceImpl {

    /**
     * dependency of Firestore .
     */
    private final FireStoreService fireStoreService;

    /**
     * Constructs a new AssignmentServiceImpl
     * with the specified FireStoreService.
     *
     * @param fireStore the FireStoreService to be used
     */
    @Autowired
    public AssignmentServiceImpl(final FireStoreService fireStore) {
        this.fireStoreService = fireStore;
    }

    /**
     * Creates a new assignment by invoking
     * the addAssignment method of the FireStoreService.
     *
     * @param assignment the assignment to be created
     * @throws ExecutionException   if an error occurs
     * during the execution of the operation
     * @throws InterruptedException if the current thread
     * is interrupted while waiting for the operation to complete
     */
    public void createUser(final Assignment assignment)
            throws ExecutionException, InterruptedException {
        fireStoreService.addAssignment(assignment);
    }

    /**
     * Updates an existing assignment by invoking the
     * updateDocument method of the FireStoreService.
     *
     * @param assignment the assignment to be updated
     * @throws ExecutionException   if an error occurs
     * during the execution of the operation
     * @throws InterruptedException if the current thread
     * is interrupted while waiting for the operation to complete
     */
    public void updateAssignment(final Assignment assignment)
            throws ExecutionException, InterruptedException {
        fireStoreService.updateDocument(assignment);
    }
}
