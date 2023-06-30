package com.knoldus.assignment_management_system.dao;

import com.knoldus.assignment_management_system.model.KipKup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KipKupRepository extends JpaRepository<KipKup,Long> {
}
