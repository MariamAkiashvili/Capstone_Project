package com.capstoneProject.demo.repository;

import com.capstoneProject.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
