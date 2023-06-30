package com.knoldus.assignment_management_system.dao;

import com.knoldus.assignment_management_system.model.InternMentorMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Intern_Mentor_Repository extends JpaRepository<InternMentorMap,Long> {

}
