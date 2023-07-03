package com.knoldus.assignment_management_system.dao;

import com.knoldus.assignment_management_system.model.InternMentorMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing and manipulating Intern-Mentor mapping data.
 */
@Repository
public interface InternMentorRepository extends JpaRepository<InternMentorMap, Long> {

}