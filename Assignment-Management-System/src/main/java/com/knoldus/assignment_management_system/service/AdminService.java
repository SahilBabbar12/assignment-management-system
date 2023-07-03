package com.knoldus.assignment_management_system.service;

import com.knoldus.assignment_management_system.model.InternMentorMap;
import com.knoldus.assignment_management_system.model.KipKup;

/**
 * Service interface for administrative operations.
 */
public interface AdminService {

    /**
     * Creates a KipKup plan.
     *
     * @param kipKupPlan the KipKup plan to be created
     * @return the created KipKup plan
     */
    KipKup createPlan(KipKup kipKupPlan);

    /**
     * Updates a KipKup plan.
     *
     * @param kipKupPlan the KipKup plan to be updated
     * @return the updated KipKup plan
     */
    KipKup updatePlan(KipKup kipKupPlan);

    /**
     * Adds an Intern-Mentor mapping.
     *
     * @param internMentorMap the Intern-Mentor mapping to be added
     * @return the added Intern-Mentor mapping
     */
    InternMentorMap addInternMentor(InternMentorMap internMentorMap);

    /**
     * Updates an Intern-Mentor mapping with a new Mentor.
     *
     * @param internMentorMap the Intern-Mentor mapping to be updated
     * @param mentorId        the ID of the new Mentor
     * @return the updated Intern-Mentor mapping
     */
    InternMentorMap updateInternMentor(InternMentorMap internMentorMap, Long mentorId);
}
