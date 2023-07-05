package com.knoldus.assignment_management_system;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.knoldus.assignment_management_system.model.Assignment;
import com.knoldus.assignment_management_system.service.serviceimpl.FireStoreService;
import jnr.posix.Times;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.ExecutionException;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FireStoreServiceImplTest {
    @Mock
    private Firestore fireStoreMock;

    @Mock
    private CollectionReference collectionReferenceMock;
    @Mock
    private DocumentReference documentReferenceMock;
    @Mock
    private ApiFuture<WriteResult> apiFutureMock;
    @Mock
    private WriteResult writeResultMock;
    @InjectMocks
    private FireStoreService fireStoreService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        fireStoreService = new FireStoreService(fireStoreMock);
    }

    @Test
    public void testAddUser() throws ExecutionException, InterruptedException {
        Assignment assignment = new Assignment();
        assignment.setId("1");
        assignment.setTechnology("Java");

        when(fireStoreMock.collection("users")).thenReturn(collectionReferenceMock);
        when(collectionReferenceMock.document(anyString())).thenReturn(documentReferenceMock);
        when(documentReferenceMock.set(ArgumentMatchers.any(Assignment.class))).thenReturn(apiFutureMock);
        when(apiFutureMock.get()).thenReturn(writeResultMock);

        fireStoreService.addAssignment(assignment);

        verify(fireStoreMock).collection("users");
        verify(collectionReferenceMock).document(anyString());
        verify(documentReferenceMock).set(ArgumentMatchers.any(Assignment.class));
        verify(apiFutureMock).get();

    }
}