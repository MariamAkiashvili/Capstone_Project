package com.capstoneProject.demo.service;

import com.capstoneProject.demo.dtos.CourseDTO;

import java.util.List;

public interface CourseService {
    List<CourseDTO> getAllCourse();
    CourseDTO addCurse(CourseDTO courseDTO);
    void deleteCourse(long id);
}
