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

@Slf4j
@Service
public class FireStoreService {

    private Firestore firestore;

    @Autowired
    public FireStoreService(Firestore firestore) {
        this.firestore = firestore;
    }

    public void addUser(Assignment assignment) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> result = firestore.collection("users").document(String.valueOf(assignment.getId())).set(assignment);
        log.info("Update time : " + result.get().getUpdateTime());
    }
    public void updateDocument(Assignment assignment) throws ExecutionException, InterruptedException {
        // Update an existing document
        DocumentReference docRef = firestore.collection("users").document(assignment.getId());
        Map<String, Object> updates = new HashMap<>();
        updates.put("assignedTo", assignment.getAssignedTo());
        updates.put("createdBy", assignment.getCreatedBy());
        updates.put("technology", assignment.getTechnology());
        updates.put("topic", assignment.getTopic());
        updates.put("questions", assignment.getQuestions());
        updates.put("field2", 123);

        // Perform the update operation
        ApiFuture<WriteResult> future = docRef.update(updates);

// (async) Update one field

// ...
        WriteResult result = future.get();
        System.out.println("Write result: " + result);
    }
}