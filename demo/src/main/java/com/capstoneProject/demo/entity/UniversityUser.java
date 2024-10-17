package com.capstoneProject.demo.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "university_user")
public class UniversityUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "university_user_id")
    private long universityUserId;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "email", length = 50)
    private String email;

    @ManyToOne
    @JoinColumn(name = "user_role_code", referencedColumnName = "user_role_code", nullable = false)
    private UserRole userRoleCode;

    private String password;

    public long getId() {
        return universityUserId;
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

    public UserRole getUserRole_code() {
        return userRoleCode;
    }

    public void setUserRole_code(UserRole userRole_code) {
        this.userRoleCode = userRole_code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUniversityUserId(long l) {
        this.universityUserId = l;
    }
}
