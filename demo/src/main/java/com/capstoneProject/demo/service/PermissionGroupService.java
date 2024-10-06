package com.capstoneProject.demo.service;

import com.capstoneProject.demo.dtos.PermissionGroupDTO;

import java.util.List;

public interface PermissionGroupService {
    List<PermissionGroupDTO> getPermissionByUserRoleCode(String userRoleCode);

    List<PermissionGroupDTO> getPermissionByAccessTypeCode(String accessTypeCode);

    PermissionGroupDTO addPermission(PermissionGroupDTO permissionGroupDTO);

    void deletePermission(long id);
}
