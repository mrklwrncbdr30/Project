package com.teamd.teamdspringapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamd.teamdspringapi.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
