package com.capstoneProject.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "permission_group")
public class PermissionGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_group_id")
    private long permission_group_id;

    @ManyToOne
    @JoinColumn (name = "user_role_code", referencedColumnName = "user_role_code", nullable = false)
    private UserRole userRoleCode;

    @ManyToOne
    @JoinColumn (name = "access_type_code", referencedColumnName = "access_type_code", nullable = false)
    private AccessType accessType;


    public AccessType getAccessType() {
        return accessType;
    }

    public void setAccessType(AccessType accessType) {
        this.accessType = accessType;
    }

    public UserRole getUserRoleCode() {
        return userRoleCode;
    }

    public void setUserRoleCode(UserRole userRoleCode) {
        this.userRoleCode = userRoleCode;
    }

    public long getPermission_group_id() {
        return permission_group_id;
    }

    public void setPermission_group_id(long permission_group_id) {
        this.permission_group_id = permission_group_id;
    }
}
