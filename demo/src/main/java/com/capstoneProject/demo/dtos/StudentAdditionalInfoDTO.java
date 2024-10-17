package com.capstoneProject.demo.dtos;

public class StudentAdditionalInfoDTO {
    private long additionalInfoId;
    private UniversityUserDTO universityUser;
    private FacultyDTO faculty;
    private boolean hasActiveStatus;
    private int currentStudyYear;
    private String phone;

    public UniversityUserDTO getUniversityUser() {
        return universityUser;
    }

    public void setUniversityUser(UniversityUserDTO universityUser) {
        this.universityUser = universityUser;
    }

    public FacultyDTO getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyDTO faculty) {
        this.faculty = faculty;
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

    public long getAdditionalInfoId() {
        return additionalInfoId;
    }

    public void setAdditionalInfoId(long additionalInfoId) {
        this.additionalInfoId = additionalInfoId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
