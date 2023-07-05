package com.knoldus.assignment_management_system.service.serviceimpl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.knoldus.assignment_management_system.model.Assignment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**

 Service for interacting with Firestore to add assignments.
 */
@Slf4j
@Service
public class FireStoreService {
    /**
     * The Firestore instance
     * for operations of firestore.
     */
    private Firestore firestore;

    /**
     * Constructs a new FireStoreService instance.
     *
     * @param firestoreInstance The Firestore instance
     *                 to use for database operations.
     */
    @Autowired
    public FireStoreService(final Firestore firestoreInstance) {
        this.firestore = firestoreInstance;
    }

    /**
     * Adds an assignment to the Firestore database.
     *
     * @param assignment The Assignment object
     *                  representing the assignment to be added.
     * @throws ExecutionException   if error occurs during execution.
     * @throws InterruptedException if operation is interrupted.
     */
    public void addAssignment(final Assignment assignment)
            throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> result = firestore.collection("users")
                .document(String.valueOf(assignment.getId()))
                .set(assignment);
        log.info("Update time: " + result.get().getUpdateTime());
    }

    /**
     * Updates an existing assignment document in Firestore.
     *
     * @param assignment The Assignment object
     *                  containing the updated assignment details.
     * @throws ExecutionException   if an error occurs during execution.
     * @throws InterruptedException if the operation is interrupted.
     */
    public void updateDocument(final Assignment assignment)
            throws ExecutionException, InterruptedException {
        DocumentReference docRef = firestore.collection("users")
                .document(assignment.getId());
        Map<String, Object> updates = new HashMap<>();
        updates.put("assignedTo", assignment.getAssignedTo());
        updates.put("createdBy", assignment.getCreatedBy());
        updates.put("technology", assignment.getTechnology());
        updates.put("topic", assignment.getTopic());
        updates.put("questions", assignment.getQuestions());
        updates.put("field2", 123);
        ApiFuture<WriteResult> future = docRef.update(updates);
        WriteResult result = future.get();
        System.out.println("Write result: " + result);
    }
}
