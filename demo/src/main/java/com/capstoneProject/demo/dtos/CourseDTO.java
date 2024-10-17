package com.capstoneProject.demo.dtos;

import com.capstoneProject.demo.entity.Faculty;
import com.capstoneProject.demo.entity.UniversityUser;

public class CourseDTO {
    private String courseCode;
    private String courseName;
    private UniversityUserDTO lecturer;
    private int maxNumberOfStudents;
    private FacultyDTO faculty;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public UniversityUserDTO getLecturer() {
        return lecturer;
    }

    public void setLecturer(UniversityUserDTO lecturer) {
        this.lecturer = lecturer;
    }

    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }

    public void setMaxNumberOfStudents(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public FacultyDTO getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyDTO faculty) {
        this.faculty = faculty;
    }
}
