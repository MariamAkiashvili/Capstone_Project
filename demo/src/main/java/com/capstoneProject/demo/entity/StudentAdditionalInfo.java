package com.capstoneProject.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student_additional_info")
public class StudentAdditionalInfo {

    @Id
    @OneToOne
    @JoinColumn(name = "university_user_id", referencedColumnName = "university_user_id")
    private UniversityUser universityUser;

    @ManyToOne
    @JoinColumn(name = "course_code", referencedColumnName = "course_code", nullable = false)
    private Course course;

    @Column(name = "has_active_status")
    private boolean hasActiveStatus;

    @Column (name = "current_study_year")
    private int currentStudyYear;


    public UniversityUser getUniversityUser() {
        return universityUser;
    }

    public void setUniversityUser(UniversityUser universityUser) {
        this.universityUser = universityUser;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public boolean getHasActiveStatus() {
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