package com.knoldus.assignment_management_system.service;

import com.knoldus.assignment_management_system.model.Mentor;

import java.util.List;

public interface MentorService {

    /**
     * Retrieves all the mentors.
     *
     * @return a list of all the mentors
     */
    List<Mentor> getMentors();

    /**
     * Adds details of a new mentor.
     *
     * @param mentor the mentor to be added
     * @return the added mentor
     */
    Mentor addMentorDetails(Mentor mentor);

    /**
     * Deletes a mentor by ID.
     *
     * @param id the ID of the mentor to be deleted
     * @return a status message indicating the result of the deletion
     */
    String deleteMentorById(Long id);

    /**
     * Retrieves the details of a mentor by ID.
     *
     * @param id the ID of the mentor
     * @return the mentor details
     */
    Mentor getMentorDetail(Long id);

    /**
     * Updates a mentor.
     *
     * @param mentor the mentor to be updated
     * @return the updated mentor
     */
    Mentor updateMentor(Mentor mentor);
}