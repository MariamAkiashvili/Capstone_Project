package com.capstoneProject.demo.dtos;

import java.util.List;

public class StudentProfileDTO {
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String facultyName;
    private String courseName;
    private Integer currentStudyYear;
    private Boolean hasActiveStatus;
    private String phone;
    private List<String> courses;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCurrentStudyYear() {
        return currentStudyYear;
    }

    public void setCurrentStudyYear(Integer currentStudyYear) {
        this.currentStudyYear = currentStudyYear;
    }

    public Boolean getHasActiveStatus() {
        return hasActiveStatus;
    }

    public void setHasActiveStatus(Boolean hasActiveStatus) {
        this.hasActiveStatus = hasActiveStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
}
