package com.teamd.teamdspringapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamd.teamdspringapi.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long>{

}
