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

import com.teamd.teamdspringapi.entity.Enrollment;
import com.teamd.teamdspringapi.service.EnrollmentService;


@RestController
@RequestMapping("/api/enrollments")
@CrossOrigin("http://localhost:5173")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping
    public List<Enrollment> getAllEnrollments(){
        return enrollmentService.getAllEnrollments();
    }

      @GetMapping("/{EnrollmentID}")
    public Enrollment getEnrollmentById(@PathVariable Long EnrollmentID) {
        return enrollmentService.getEnrollmentById(EnrollmentID);
    }

     @PostMapping
    public Enrollment saveEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentService.saveEnrollment(enrollment);
    }

    @DeleteMapping("/{EnrollmentID}")
    public void deleteEnrollment(@PathVariable Long EnrollmentID) {
        enrollmentService.deleteEnrollment(EnrollmentID);
    }
}
