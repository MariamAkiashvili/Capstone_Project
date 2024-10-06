package com.capstoneProject.demo.dtos;

public class PermissionGroupDTO {
    private long permission_group_id;
    private UserRoleDTO userRoleCode;
    private AccessTypeDTO accessType;


    public long getPermission_group_id() {
        return permission_group_id;
    }

    public void setPermission_group_id(long permission_group_id) {
        this.permission_group_id = permission_group_id;
    }

    public UserRoleDTO getUserRoleCode() {
        return userRoleCode;
    }

    public void setUserRoleCode(UserRoleDTO userRoleCode) {
        this.userRoleCode = userRoleCode;
    }

    public AccessTypeDTO getAccessType() {
        return accessType;
    }

    public void setAccessType(AccessTypeDTO accessType) {
        this.accessType = accessType;
    }
}
