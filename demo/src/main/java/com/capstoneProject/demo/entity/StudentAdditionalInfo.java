package com.capstoneProject.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student_additional_info")
public class StudentAdditionalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "additional_info_id")
    private long additionalInfoID;

    @OneToOne
    @JoinColumn(name = "university_user_id", referencedColumnName = "university_user_id")
    private UniversityUser universityUser;

    @ManyToOne
    @JoinColumn(name = "faculty_code", referencedColumnName = "faculty_code", nullable = false)
    private Faculty faculty;

    @Column(name = "has_active_status")
    private boolean hasActiveStatus;

    @Column (name = "current_study_year")
    private int currentStudyYear;

    @Column(name = "phone")
    private String phone;

    public UniversityUser getUniversityUser() {
        return universityUser;
    }

    public void setUniversityUser(UniversityUser universityUser) {
        this.universityUser = universityUser;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
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

    public long getAdditionalInfoID() {
        return additionalInfoID;
    }

    public void setAdditionalInfoID(long additionalInfoID) {
        this.additionalInfoID = additionalInfoID;
    }

    public boolean isHasActiveStatus() {
        return hasActiveStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}