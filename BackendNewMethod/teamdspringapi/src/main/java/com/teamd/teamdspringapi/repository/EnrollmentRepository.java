package com.teamd.teamdspringapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamd.teamdspringapi.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

}
