package com.knoldus.assignment_management_system.controller;

import com.knoldus.assignment_management_system.model.Assignment;
import com.knoldus.assignment_management_system.model.Mentor;
import com.knoldus.assignment_management_system.service.serviceimpl.AssignmentServiceImpl;
import com.knoldus.assignment_management_system.service.serviceimpl.MentorServiceImpl;
import com.knoldus.assignment_management_system.service.serviceimpl.PublisherExample;
import org.springframework.beans.factory.annotation.Autowired;
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

    private MentorServiceImpl mentorService;
    private AssignmentServiceImpl assignmentService;

    @Autowired
    public MentorController(MentorServiceImpl mentorService, AssignmentServiceImpl assignmentService) {
        this.mentorService = mentorService;
        this.assignmentService = assignmentService;
    }

    /**
     * Retrieves a list of all mentors.
     *
     * @return ResponseEntity with the list of mentors
     */
    @GetMapping("/showMentors")
    public ResponseEntity<List<Mentor>> getAllMentors() {
        return ResponseEntity.ok(mentorService.getMentors());
    }

    /**
     * Adds a new mentor.
     *
     * @param mentor the mentor to be added
     * @return ResponseEntity with the added mentor
     */
    @PostMapping("/new-mentor")
    public ResponseEntity<Mentor> addMentor(@RequestBody Mentor mentor) {
        return ResponseEntity.ok(mentorService.addMentorDetails(mentor));
    }

    /**
     * Deletes a mentor by ID.
     *
     * @param id the ID of the mentor to be deleted
     */
    @DeleteMapping("deleteMentor/{id}")
    public void deleteProjectById(@PathVariable Long id) {
        mentorService.deleteMentorById(id);
    }

    /**
     * Retrieves mentor details by ID.
     *
     * @param id the ID of the mentor
     * @return ResponseEntity with the mentor details
     */
    @GetMapping("/getMentor/{id}")
    public ResponseEntity<Mentor> getMentorDetailById(@PathVariable Long id) {
        return ResponseEntity.ok(mentorService.getMentorDetail(id));
    }

    /**
     * Updates a mentor.
     *
     * @param mentor the mentor to be updated
     * @return ResponseEntity with the updated mentor
     */
    @PutMapping("/updateMentor")
    public ResponseEntity<Mentor> updateMentor(@RequestBody Mentor mentor) {
        return ResponseEntity.ok(mentorService.updateMentor(mentor));
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
    public String createDocument(@RequestBody Assignment assignment) throws IOException, ExecutionException, InterruptedException {
        assignmentService.createUser(assignment);
        try {
            String projectId = "nodal-descent-389716";
            String topicId = "pub-sub-Topic";
            PublisherExample.publisherExample(projectId, topicId, "Assignment published ss");
            return "Message published successfully!";
        } catch (InterruptedException e) {
            return "Error publishing message: " + e.getMessage();
        }
    }
}