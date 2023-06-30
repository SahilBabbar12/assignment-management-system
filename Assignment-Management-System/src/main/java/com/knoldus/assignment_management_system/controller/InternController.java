package com.knoldus.assignment_management_system.controller;

import com.knoldus.assignment_management_system.model.Intern;
import com.knoldus.assignment_management_system.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InternController {
    @Autowired
    InternService internService;

    @GetMapping("/list-all-interns")
    public ResponseEntity<List<Intern>> getAllInterns(){
       return  ResponseEntity.ok(internService.getInterns());
    }

    @GetMapping("/intern-detail/{id}")
    public ResponseEntity<Intern> getIntern(@PathVariable Long id){
        return ResponseEntity.ok(internService.getInternDetail(id));
    }
    @PostMapping("/insert-newIntern")
    public ResponseEntity<Intern> addIntern(@RequestBody Intern intern){
        return ResponseEntity.ok(internService.addNewIntern(intern));
    }
    @PutMapping("/update-intern/{id}")
    public ResponseEntity<Intern> updateIntern(@RequestBody Intern intern){
        return ResponseEntity.ok(internService.updateIntern(intern));
    }
    @DeleteMapping("delete-intern/{id}")
    public ResponseEntity<String> deleteIntern(@PathVariable Long id){
        return ResponseEntity.ok(internService.deleteIntern(id));
    }
}
