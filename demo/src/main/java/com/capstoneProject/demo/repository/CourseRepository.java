package com.capstoneProject.demo.repository;

import com.capstoneProject.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Object> findByCourseCode(String courseCode);
}
