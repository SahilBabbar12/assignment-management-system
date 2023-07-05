package com.knoldus.assignment_management_system.service.serviceimpl;

import com.knoldus.assignment_management_system.dao.InternRepository;
import com.knoldus.assignment_management_system.exception.EmptyInputException;
import com.knoldus.assignment_management_system.exception.NoSuchElementException;
import com.knoldus.assignment_management_system.model.Intern;
import com.knoldus.assignment_management_system.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternServiceImpl implements InternService {
    /**
     * The repository for internRepository.
     */
    @Autowired
    private InternRepository internRepository;

    /**
     * Retrieves all the interns.
     *
     * @return a list of all the interns
     */
    @Override
    public List<Intern> getInterns() {
        return internRepository.findAll();
    }

    /**
     * Adds a new intern.
     *
     * @param intern the intern to be added
     * @return the added intern
     * @throws EmptyInputException if the input fields are empty
     */
    @Override
    public Intern addNewIntern(final Intern intern) {
        if (intern.getFirstName().isEmpty()) {
            throw new EmptyInputException("Input fields are empty");
        } else {
            return internRepository.save(intern);
        }
    }

    /**
     * Retrieves the details of an intern by ID.
     *
     * @param id the ID of the intern
     * @return the intern details
     * @throws NoSuchElementException if no intern is found with the given ID
     */
    @Override
    public Intern getInternDetail(
            final Long id) {
        return internRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("No Intern Found"));
    }

    /**
     * Updates an intern.
     *
     * @param intern the intern to be updated
     * @return the updated intern
     */
    @Override
    public Intern updateIntern(final Intern intern) {
        if (internRepository.findById(intern.getId()).isPresent()) {
            return internRepository.save(intern);
        } else {
            throw new NoSuchElementException("Intern not found");
        }

    }

    /**
     * Deletes an intern by ID.
     *
     * @param id the ID of the intern to be deleted
     * @return a status message indicating the result of the deletion
     */
    @Override
    public String deleteIntern(final Long id) {
        if (internRepository.findById(id).isPresent()) {
            internRepository.deleteById(id);
            return "Intern with ID " + id + " deleted successfully";
        } else {
            throw new NoSuchElementException("Intern not found");
        }
    }
}
