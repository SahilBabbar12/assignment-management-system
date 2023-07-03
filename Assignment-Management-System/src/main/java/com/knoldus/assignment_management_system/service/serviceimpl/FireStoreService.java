package com.knoldus.assignment_management_system.service.serviceimpl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.knoldus.assignment_management_system.model.Assignment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}