package com.knoldus.assignment_management_system.controller;

import com.knoldus.assignment_management_system.model.InternMentorMap;
import com.knoldus.assignment_management_system.model.KipKup;
import com.knoldus.assignment_management_system.service.serviceimpl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling admin-related operations.
 */
@RestController
public class AdminController {

    @Autowired
    AdminServiceImpl adminService;

    /**
     * Creates a new KipKup plan.
     *
     * @param kipKup the KipKup plan to be created
     * @return the created KipKup plan
     */
    @PostMapping("/add-kip-kup-Plan")
    public KipKup createKipKupPlan(@RequestBody KipKup kipKup) {
        return adminService.createPlan(kipKup);
    }

    /**
     * Updates an existing KipKup plan.
     *
     * @param kipKup the KipKup plan to be updated
     * @return the updated KipKup plan
     */
    @PutMapping("/update-kip-kup-plan")
    public KipKup updateKipKupPlan(@RequestBody KipKup kipKup) {
        return adminService.updatePlan(kipKup);
    }

    /**
     * Assigns a mentor to an intern.
     *
     * @param internMentorMap the mapping between intern and mentor
     * @return the updated InternMentorMap object
     */
    @PostMapping("assign-mentor-intern")
    public InternMentorMap addDetail(@RequestBody InternMentorMap internMentorMap) {
        return adminService.addInternMentor(internMentorMap);
    }
}