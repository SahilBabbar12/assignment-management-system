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
    @Autowired
    InternRepository internRepository;
    @Override
    public List<Intern> getInterns() {
        return (internRepository.findAll());
    }

    @Override
    public Intern addNewIntern(Intern intern) {
        if(intern.getFirst_name().isEmpty())
            throw new EmptyInputException("Input fields are empty");
        else
            return internRepository.save(intern);

    }

    @Override
    public Intern getInternDetail(Long id) {
        return internRepository.findById(id).orElseThrow(()-> new NoSuchElementException("No Intern Found"));
    }

    @Override
    public Intern updateIntern(Intern intern) {
        if(internRepository.findById(intern.getId()).isPresent())
            return internRepository.save(intern);
        else
            return null;
    }

    @Override
    public String deleteIntern(Long id) {
        if(internRepository.findById(id).isPresent())
        {
            internRepository.deleteById(id);
            return "intern id"+id+"successfully";
        }
        else
            return "intern not found";

    }
}
