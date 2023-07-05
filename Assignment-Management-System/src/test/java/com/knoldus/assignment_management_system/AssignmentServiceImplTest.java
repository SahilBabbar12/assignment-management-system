package com.knoldus.assignment_management_system;

import com.knoldus.assignment_management_system.model.Assignment;
import com.knoldus.assignment_management_system.model.Questions;
import com.knoldus.assignment_management_system.service.serviceimpl.AssignmentServiceImpl;
import com.knoldus.assignment_management_system.service.serviceimpl.FireStoreService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

public class AssignmentServiceImplTest {

    @Mock
    private FireStoreService fireStoreServiceMock;

    @InjectMocks
    private AssignmentServiceImpl assignmentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser() throws ExecutionException, InterruptedException {
        Assignment assignment = new Assignment();
        assignment.setId("1");
        assignment.setTechnology("Java");
        assignment.setTopic("Object-Oriented Programming");
        assignment.setCreatedBy("Shiv");
        assignment.setAssignedTo("Jasleen");

        List<Questions> questions = new ArrayList<>();
        Questions question1 = new Questions(1L, "What is encapsulation?");
        Questions question2 = new Questions(2l, "What is inheritance?");
        questions.add(question1);
        questions.add(question2);
        assignment.setQuestions(questions);

        doNothing().when(fireStoreServiceMock).addAssignment(any(Assignment.class));

        assignmentService.createUser(assignment);

        verify(fireStoreServiceMock).addAssignment(assignment);
    }
}

