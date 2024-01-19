package com.teamd.teamdspringapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamd.teamdspringapi.entity.Instructor;
import com.teamd.teamdspringapi.repository.InstructorRepository;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    public List<Instructor> getAllInstructor() {
        return instructorRepository.findAll();
    }

    public Instructor getInstructorById(Long InstructorID) {
        return instructorRepository.findById(InstructorID).orElse(null);
    }

    public Instructor saveInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public void deleteInstructor(Long InstructorID) {
        instructorRepository.deleteById(InstructorID);
    }
}