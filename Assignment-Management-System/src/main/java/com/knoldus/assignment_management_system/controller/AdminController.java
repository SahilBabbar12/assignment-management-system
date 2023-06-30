package com.knoldus.assignment_management_system.controller;

import com.knoldus.assignment_management_system.model.InternMentorMap;
import com.knoldus.assignment_management_system.model.KipKup;
import com.knoldus.assignment_management_system.service.serviceimpl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    AdminServiceImpl adminService;


    @PostMapping("/addKipKupPlan")
    public KipKup createKipKupPlan(@RequestBody KipKup kipKup){
        return adminService.createPlan(kipKup);
    }

    @PutMapping("/updateKipKupPlan")
    public KipKup updateKipKupPlan(@RequestBody KipKup kipKup){
        return adminService.updatePlan(kipKup);
    }

    @PostMapping("assign-mentor-intern")
    public InternMentorMap addDetail(@RequestBody InternMentorMap internMentorMap){
        return adminService.addInternMentor(internMentorMap);
    }

}

