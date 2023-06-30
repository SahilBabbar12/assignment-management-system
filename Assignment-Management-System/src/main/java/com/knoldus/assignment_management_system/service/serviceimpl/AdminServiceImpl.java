package com.knoldus.assignment_management_system.service.serviceimpl;

import com.knoldus.assignment_management_system.dao.InternRepository;
import com.knoldus.assignment_management_system.dao.Intern_Mentor_Repository;
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
    Intern_Mentor_Repository internMentorRepository;
    private KipKup kipKup;
    @Override
    public KipKup createPlan(KipKup kipKupPlan) {
        return kipKupRepository.save(kipKupPlan);
    }

    @Override
    public KipKup updatePlan(KipKup kipKupPlan) {
        if(kipKupRepository.findById(kipKupPlan.getSessionId()).isPresent())
            return kipKupRepository.save(kipKupPlan);
        else
            return null;
    }
    @Override
    public InternMentorMap addInternMentor(InternMentorMap internMentorMap) {
        if(internRepository.existsById(internMentorMap.getIntern()) && mentorRepository.existsById(internMentorMap.getMentor())){
            return internMentorRepository.save(internMentorMap);
        }else {
            throw new NoSuchElementException("Resource not found");
        }

    }
    @Override
    public InternMentorMap updateInternMentor(InternMentorMap internMentorMap, Long mentorId) {
        if(internMentorMap.getIntern() != null){
            internMentorMap.setMentor(mentorId);
            return internMentorRepository.save(internMentorMap);
        }
        else{
            throw new NoSuchElementException("Resource not found");
        }
    }
}