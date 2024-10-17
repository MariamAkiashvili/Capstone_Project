package com.capstoneProject.demo.convertors;

import com.capstoneProject.demo.dtos.PermissionGroupDTO;
import com.capstoneProject.demo.entity.PermissionGroup;

public class PermissionGroupConvertor {
    public static PermissionGroupDTO convertTo(PermissionGroup permissionGroup) {
        PermissionGroupDTO permissionGroupDTO = new PermissionGroupDTO();
        permissionGroupDTO.setPermission_group_id(permissionGroup.getPermission_group_id());
        permissionGroupDTO.setAccessType(AccessTypeConvertor.convertTo(permissionGroup.getAccessType()));
        permissionGroupDTO.setUserRoleCode(UserRoleConvertor.convetTo(permissionGroup.getUserRoleCode()));

        return permissionGroupDTO;
    }
}
