package com.knoldus.assignment_management_system.service;

import com.knoldus.assignment_management_system.model.Intern;

import java.util.List;

public interface InternService {

    /**
     * Retrieves all the interns.
     *
     * @return a list of all the interns
     */
    List<Intern> getInterns();

    /**
     * Adds details of a new intern.
     *
     * @param intern the intern to be added
     * @return the added intern
     */
    Intern addNewIntern(Intern intern);

    /**
     * Retrieves the details of an intern by ID.
     *
     * @param id the ID of the intern
     * @return the intern details
     */
    Intern getInternDetail(Long id);

    /**
     * Updates an intern.
     *
     * @param intern the intern to be updated
     * @return the updated intern
     */
    Intern updateIntern(Intern intern);

    /**
     * Deletes an intern by ID.
     *
     * @param id the ID of the intern to be deleted
     * @return a status message indicating the result of the deletion
     */
    String deleteIntern(Long id);
}
