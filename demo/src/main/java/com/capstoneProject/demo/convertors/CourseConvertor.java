package com.capstoneProject.demo.convertors;

import com.capstoneProject.demo.dtos.CourseDTO;
import com.capstoneProject.demo.entity.Course;

public class CourseConvertor {
    public static CourseDTO convertTo(Course course){
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseCode(course.getCourseCode());
        courseDTO.setCourseName(course.getCourseName());
        courseDTO.setFaculty(FacultyConventor.convertTo(course.getFaculty()));
        courseDTO.setMaxNumberOfStudents(course.getMaxNumberOfStudents());
        courseDTO.setLecturer(UserConvertor.convertToDTO(course.getLecturer()));

        return courseDTO;
    }
}
