package com.knoldus.assignment_management_system.service.serviceimpl;

import com.knoldus.assignment_management_system.dao.MentorRepository;
import com.knoldus.assignment_management_system.exception.NoSuchElementException;
import com.knoldus.assignment_management_system.model.Mentor;
import com.knoldus.assignment_management_system.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MentorServiceImpl implements MentorService {
    /**
     * The repository for mentor.
     */
    @Autowired
    private MentorRepository mentorRepository;

    /**
     * Retrieves a list of all mentors.
     *
     * @return List of Mentor objects representing all mentors.
     */
    @Override
    public List<Mentor> getMentors() {
        return mentorRepository.findAll();
    }

    /**
     * Adds mentor details to the system.
     *
     * @param mentor The Mentor object containing the details to be added.
     * @return The Mentor object that was added.
     */
    @Override
    public Mentor addMentorDetails(final Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    /**
     * Deletes a mentor by their ID.
     *
     * @param id The ID of the mentor to be deleted.
     * @return A message indicating the success of the deletion.
     * @throws NoSuchElementException if the mentor
     * with the given ID does not exist.
     */
    public String deleteMentorById(final Long id) {
        if (mentorRepository.findById(id).isPresent()) {
            mentorRepository.deleteById(id);
            return "Mentor with ID " + id + " deleted successfully.";
        } else {
            throw new NoSuchElementException("Mentor not found");
        }
    }

    /**
     * Retrieves the details of a mentor by their ID.
     *
     * @param id The ID of the mentor to retrieve.
     * @return The Mentor object with the specified ID.
     * @throws NoSuchElementException if the mentor
     * with the given ID does not exist.
     */
    @Override
    public Mentor getMentorDetail(final Long id) {
        return mentorRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Mentor not found"));
    }

    /**
     * Updates the details of a mentor.
     *
     * @param mentor The Mentor object containing the updated details.
     * @return The updated Mentor object.
     * @throws NoSuchElementException if the mentor
     * with the given ID does not exist.
     */
    @Override
    public Mentor updateMentor(final Mentor mentor) {
        if (mentorRepository.findById((long) mentor
                .getMentorId()).isPresent()) {
            return mentorRepository.save(mentor);
        } else {
            throw new NoSuchElementException("Mentor not found");
        }
    }
}
