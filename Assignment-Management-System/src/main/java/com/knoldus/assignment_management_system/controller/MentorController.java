package com.knoldus.assignment_management_system.controller;

import com.knoldus.assignment_management_system.model.Assignment;
import com.knoldus.assignment_management_system.model.Mentor;
import com.knoldus.assignment_management_system.service.serviceimpl.AssignmentPublisher;
import com.knoldus.assignment_management_system.service.serviceimpl.AssignmentServiceImpl;
import com.knoldus.assignment_management_system.service.serviceimpl.MentorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Controller class for handling mentor-related operations.
 */
@RestController
public class MentorController {

    /**
     * Mentor service for handling mentor operations.
     */
    private MentorServiceImpl mentorService;
    /**
     * Assignment service for handling assignment operations.
     */
    private AssignmentServiceImpl assignmentService;

    /**
     * Google Cloud project ID.
     */
    @Value("${google.application.project-id}")
    private String projectId;

    /**
     * Google Cloud Pub/Sub topic ID.
     */
    @Value("${google.application.topicId}")
    private String topicId;

    /**
     * Constructs a new instance of the MentorController class.
     *
     * @param mentorServiceImpl    The mentor service implementation.
     * @param assignmentServiceImpl The assignment service implementation.
     */
    @Autowired
    public MentorController(final MentorServiceImpl mentorServiceImpl,
                            final AssignmentServiceImpl assignmentServiceImpl) {
        this.mentorService = mentorServiceImpl;
        this.assignmentService = assignmentServiceImpl;
    }

    /**
     * Retrieves a list of all mentors.
     *
     * @return ResponseEntity with the list of mentors
     */
    @GetMapping("/showMentors")
    public ResponseEntity<List<Mentor>> getAllMentors() {
        return ResponseEntity.ok(
                mentorService.getMentors());
    }

    /**
     * Adds a new mentor.
     *
     * @param mentor the mentor to be added
     * @return ResponseEntity with the added mentor
     */
    @PostMapping("/new-mentor")
    public ResponseEntity<Mentor> addMentor(
            @RequestBody final Mentor mentor) {
        return ResponseEntity.ok(
                mentorService.addMentorDetails(mentor));
    }

    /**
     * Deletes a mentor by ID.
     *
     * @param id the ID of the mentor to be deleted
     */
    @DeleteMapping("deleteMentor/{id}")
    public void deleteProjectById(
            @PathVariable final Long id) {
        mentorService.deleteMentorById(id);
    }

    /**
     * Retrieves mentor details by ID.
     *
     * @param id the ID of the mentor
     * @return ResponseEntity with the mentor details
     */
    @GetMapping("/get-mentor/{id}")
    public ResponseEntity<Mentor> getMentorDetailById(
            @PathVariable final Long id) {
        return ResponseEntity.ok(
                mentorService.getMentorDetail(id));
    }

    /**
     * Updates a mentor.
     *
     * @param mentor the mentor to be updated
     * @return ResponseEntity with the updated mentor
     */
    @PutMapping("/update-mentor")
    public ResponseEntity<Mentor> updateMentor(
            @RequestBody final Mentor mentor) {
        return ResponseEntity.ok(
                mentorService.updateMentor(mentor));
    }

    /**
     * Creates a new document (assignment) and publishes a message.
     *
     * @param assignment the assignment to be created and published
     * @return a string indicating the status of the message publishing
     * @throws IOException              if an I/O error occurs
     * @throws ExecutionException       if an execution error occurs
     * @throws InterruptedException    if the execution is interrupted
     */

    @PostMapping("/create-document")
    public String createDocument(@RequestBody final Assignment assignment)
            throws IOException, ExecutionException, InterruptedException {
        assignmentService.createUser(assignment);
        try {
            AssignmentPublisher
                    .publishAssignment(projectId, topicId,
                            "assignment has been published");
            return "Message published successfully!";
        } catch (InterruptedException e) {
            return "Error publishing message: " + e.getMessage();
        }
    }
    /**
     * Updates a document for the given assignment.
     *
     * @param assignment
     * The assignment object containing the updated information.
     * @return A message indicating the status of the update operation.
     * @throws ExecutionException
     * If an execution exception occurs during publishing.
     * @throws InterruptedException
     * If the execution is interrupted during publishing.
     */
    @PutMapping("/update-document")
    public String updateDocument(
            @RequestBody final Assignment assignment)
            throws ExecutionException, InterruptedException {
        assignmentService.updateAssignment(assignment);
        try {
            AssignmentPublisher
                    .publishAssignment(projectId, topicId,
                            "assignment has been updated");
            return "Message published successfully!";
        } catch (InterruptedException e) {
            return "Error publishing message: " + e.getMessage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
