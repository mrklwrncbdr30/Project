package com.teamd.teamdspringapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamd.teamdspringapi.entity.Instructor;
import com.teamd.teamdspringapi.service.InstructorService;

@RestController
@RequestMapping("/api/instructors")
@CrossOrigin("http://localhost:5173")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @GetMapping 
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructor();
    }

    @GetMapping("/{InstructorID}")
    public Instructor getInstructorById(@PathVariable Long InstructorID) {
        return instructorService.getInstructorById(InstructorID);
    }
    
    @PostMapping
    public Instructor saveInstructor(@RequestBody Instructor instructor) {
        return instructorService.saveInstructor(instructor);
    }

    @DeleteMapping("/{InstructorID}")
    public void deleteInstructor(@PathVariable Long InstructorID) {
        instructorService.deleteInstructor(InstructorID);
    }
}
