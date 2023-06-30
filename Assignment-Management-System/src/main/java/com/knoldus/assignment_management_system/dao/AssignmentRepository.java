package com.knoldus.assignment_management_system.dao;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.knoldus.assignment_management_system.model.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ExecutionException;

@Repository
public class AssignmentRepository {


//    private final Firestore firestore;
//
//    @Autowired
//    public AssignmentRepository(Firestore firestore) {
//        this.firestore = firestore;
//    }
//
//    public void addUser(Assignment assignment) throws ExecutionException, InterruptedException {
//        ApiFuture<WriteResult> result = firestore.collection("users").document(assignment.getId()).set(assignment);
//        System.out.println("Update time : " + result.get().getUpdateTime());
//    }


}
