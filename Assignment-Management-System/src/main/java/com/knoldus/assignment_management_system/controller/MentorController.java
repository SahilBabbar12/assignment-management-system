package com.knoldus.assignment_management_system.controller;

import com.knoldus.assignment_management_system.model.Mentor;
import com.knoldus.assignment_management_system.service.serviceimpl.MentorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MentorController {

    @Autowired
    MentorServiceImpl mentorService;

    @GetMapping("/showMentors")
    public ResponseEntity<List<Mentor>> getAllMentors(){
        return ResponseEntity.ok(mentorService.getMentors());
    }

    @PostMapping("/new-mentor")
    public ResponseEntity<Mentor> addMentor(@RequestBody Mentor mentor){
        return ResponseEntity.ok(mentorService.addMentorDetails(mentor));
    }

    @DeleteMapping("deleteMentor/{id}")
    public void deleteProjectById(@PathVariable Long id){
        mentorService.deleteMentorById(id);
    }

    @GetMapping("/getMentor/{id}")
    public ResponseEntity<Mentor> getMentorDetailById(@PathVariable Long id){
        return ResponseEntity.ok(mentorService.getMentorDetail(id));
    }

    @PutMapping("/updateMentor")
    public ResponseEntity<Mentor> updateMentor(@RequestBody Mentor mentor){
        return ResponseEntity.ok(mentorService.updateMentor(mentor));
    }
}