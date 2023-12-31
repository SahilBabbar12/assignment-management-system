package com.knoldus.assignment_management_system.service.serviceimpl;

import com.knoldus.assignment_management_system.dao.InternRepository;
import com.knoldus.assignment_management_system.dao.InternMentorRepository;
import com.knoldus.assignment_management_system.dao.KipKupRepository;
import com.knoldus.assignment_management_system.dao.MentorRepository;
import com.knoldus.assignment_management_system.exception.NoSuchElementException;
import com.knoldus.assignment_management_system.model.InternMentorMap;
import com.knoldus.assignment_management_system.model.KipKup;
import com.knoldus.assignment_management_system.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private KipKupRepository kipKupRepository;
    @Autowired
    InternRepository internRepository;
    @Autowired
    MentorRepository mentorRepository;
    @Autowired
    InternMentorRepository internMentorRepository;

    /**
     * Creates a KipKup plan.
     *
     * @param kipKupPlan the KipKup plan to be created
     * @return the created KipKup plan
     */
    @Override
    public KipKup createPlan(KipKup kipKupPlan) {
        return kipKupRepository.save(kipKupPlan);
    }

    /**
     * Updates a KipKup plan.
     *
     * @param kipKupPlan the KipKup plan to be updated
     * @return the updated KipKup plan
     */
    @Override
    public KipKup updatePlan(KipKup kipKupPlan) {
        if (kipKupRepository.findById(kipKupPlan.getSessionId()).isPresent())
            return kipKupRepository.save(kipKupPlan);
        else
            return null;
    }

    /**
     * Adds an Intern-Mentor mapping.
     *
     * @param internMentorMap the Intern-Mentor mapping to be added
     * @return the added Intern-Mentor mapping
     * @throws NoSuchElementException if the Intern or Mentor does not exist
     */
    @Override
    public InternMentorMap addInternMentor(InternMentorMap internMentorMap) {
        if (internRepository.existsById(internMentorMap.getIntern()) && mentorRepository.existsById(internMentorMap.getMentor())) {
            return internMentorRepository.save(internMentorMap);
        } else {
            throw new NoSuchElementException("Resource not found");
        }
    }

    /**
     * Updates an Intern-Mentor mapping with a new Mentor.
     *
     * @param internMentorMap the Intern-Mentor mapping to be updated
     * @param mentorId        the ID of the new Mentor
     * @return the updated Intern-Mentor mapping
     * @throws NoSuchElementException if the Intern does not exist
     */
    @Override
    public InternMentorMap updateInternMentor(InternMentorMap internMentorMap, Long mentorId) {
        if (internMentorMap.getIntern() != null) {
            internMentorMap.setMentor(mentorId);
            return internMentorRepository.save(internMentorMap);
        } else {
            throw new NoSuchElementException("Resource not found");
        }
    }
}