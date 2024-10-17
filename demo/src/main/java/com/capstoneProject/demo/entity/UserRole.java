package com.capstoneProject.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @Column(name = "user_role_code", length = 50)
    private String userRoleCode;

    @Column(name = "user_role_name", nullable = false, length = 50)
    private String userRoleName;

    public String getuserRoleCode() {
        return userRoleCode;
    }

    public void setCode(String code) {
        this.userRoleCode = code;
    }

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setName(String name) {
        this.userRoleName = name;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> userRoleName);
    }
}
