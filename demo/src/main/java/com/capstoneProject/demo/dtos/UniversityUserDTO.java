package com.capstoneProject.demo.dtos;

public class UniversityUserDTO {
    private long universityUserId;
    private String firstName;
    private String lastName;
    private String email;
    private String userRoleCode;

    public long getUniversityUserId() {
        return universityUserId;
    }

    public void setUniversityUserId(long universityUserId) {
        this.universityUserId = universityUserId;
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

    public String getUserRoleCode() {
        return userRoleCode;
    }

    public void setUserRoleCode(String userRoleCode) {
        this.userRoleCode = userRoleCode;
    }
}
