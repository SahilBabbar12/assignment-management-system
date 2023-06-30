package com.knoldus.assignment_management_system.service;

import com.knoldus.assignment_management_system.model.Mentor;

import java.util.List;

public interface MentorService {
    List<Mentor> getMentors();
    Mentor addMentorDetails(Mentor mentor);
    String deleteMentorById(Long id);
    Mentor getMentorDetail(Long id);
    Mentor updateMentor(Mentor mentor);
}
