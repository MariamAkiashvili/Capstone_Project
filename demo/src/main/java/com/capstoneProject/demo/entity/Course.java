package com.capstoneProject.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @Column(name = "course_code", length = 50)
    private String courseCode;

    @Column(name = "course_name", nullable = false, length = 150)
    private String courseName;

    @ManyToOne
    @JoinColumn(name = "lecturer_id", referencedColumnName = "university_user_id")
    private UniversityUser lecturer;


    @Column(name = "max_number_of_students", nullable = false)
    private int maxNumberOfStudents;

    @ManyToOne
    @JoinColumn(name = "faculty_code", referencedColumnName = "faculty_code", nullable = false)
    private Faculty faculty;


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

    public UniversityUser getLecturer() {
        return lecturer;
    }

    public void setLecturer(UniversityUser lecturer) {
        this.lecturer = lecturer;
    }

    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }

    public void setMaxNumberOfStudents(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
