package com.knoldus.assignment_management_system.controller;

import com.knoldus.assignment_management_system.model.Intern;
import com.knoldus.assignment_management_system.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling intern-related operations.
 */
@RestController
public class InternController {
    @Autowired
    InternService internService;

    /**
     * Retrieves a list of all interns.
     *
     * @return ResponseEntity containing the list of all interns
     */
    @GetMapping("/list-all-interns")
    public ResponseEntity<List<Intern>> getAllInterns() {
        return ResponseEntity.ok(internService.getInterns());
    }

    /**
     * Retrieves the details of a specific intern.
     *
     * @param id the ID of the intern
     * @return ResponseEntity containing the intern details
     */
    @GetMapping("/intern-detail/{id}")
    public ResponseEntity<Intern> getIntern(@PathVariable Long id) {
        return ResponseEntity.ok(internService.getInternDetail(id));
    }

    /**
     * Adds a new intern.
     *
     * @param intern the intern to be added
     * @return ResponseEntity containing the added intern
     */
    @PostMapping("/insert-newIntern")
    public ResponseEntity<Intern> addIntern(@RequestBody Intern intern) {
        return ResponseEntity.ok(internService.addNewIntern(intern));
    }

    /**
     * Updates the details of an existing intern.
     *
     * @param intern the updated intern details
     * @return ResponseEntity containing the updated intern
     */
    @PutMapping("/update-intern/{id}")
    public ResponseEntity<Intern> updateIntern(@RequestBody Intern intern) {
        return ResponseEntity.ok(internService.updateIntern(intern));
    }

    /**
     * Deletes an intern.
     *
     * @param id the ID of the intern to be deleted
     * @return ResponseEntity containing a success message
     */
    @DeleteMapping("delete-intern/{id}")
    public ResponseEntity<String> deleteIntern(@PathVariable Long id) {
        return ResponseEntity.ok(internService.deleteIntern(id));
    }
}