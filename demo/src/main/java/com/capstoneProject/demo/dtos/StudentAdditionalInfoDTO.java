package com.capstoneProject.demo.dtos;

public class StudentAdditionalInfoDTO {
    private UniversityUserDTO universityUser;
    private CourseDTO course;
    private boolean hasActiveStatus;
    private int currentStudyYear;

    public UniversityUserDTO getUniversityUser() {
        return universityUser;
    }

    public void setUniversityUser(UniversityUserDTO universityUser) {
        this.universityUser = universityUser;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public boolean isHasActiveStatus() {
        return hasActiveStatus;
    }

    public void setHasActiveStatus(boolean hasActiveStatus) {
        this.hasActiveStatus = hasActiveStatus;
    }

    public int getCurrentStudyYear() {
        return currentStudyYear;
    }

    public void setCurrentStudyYear(int currentStudyYear) {
        this.currentStudyYear = currentStudyYear;
    }
}
