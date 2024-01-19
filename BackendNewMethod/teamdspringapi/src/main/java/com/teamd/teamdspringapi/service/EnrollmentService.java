package com.teamd.teamdspringapi.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamd.teamdspringapi.entity.Enrollment;
import com.teamd.teamdspringapi.repository.EnrollmentRepository;

@Service
public class EnrollmentService {
@Autowired
private EnrollmentRepository enrollmentRepository;

public List<Enrollment> getAllEnrollments(){
    return enrollmentRepository.findAll();
}

public Enrollment getEnrollmentById(long EnrollmentID){
    return enrollmentRepository.findById(EnrollmentID).orElse(null);
}

public Enrollment saveEnrollment(Enrollment enrollment){
    return enrollmentRepository.save(enrollment);
}

public void deleteEnrollment(Long EnrollmentID){
    enrollmentRepository.deleteById(EnrollmentID);
}
}
