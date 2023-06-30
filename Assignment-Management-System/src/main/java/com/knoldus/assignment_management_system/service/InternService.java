package com.knoldus.assignment_management_system.service;

import com.knoldus.assignment_management_system.model.Intern;

import java.util.List;

public interface InternService {
    List<Intern> getInterns();
    Intern addNewIntern(Intern intern);
    Intern getInternDetail(Long id);
    Intern updateIntern(Intern intern);
    String deleteIntern(Long id);
}
