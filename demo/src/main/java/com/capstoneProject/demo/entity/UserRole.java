package com.capstoneProject.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @Column(name = "user_role_code", length = 50)
    private String userRoleCode;

    @Column(name = "user_role_name", nullable = false, length = 50)
    private String name;

    public String getCode() {
        return userRoleCode;
    }

    public void setCode(String code) {
        this.userRoleCode = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
