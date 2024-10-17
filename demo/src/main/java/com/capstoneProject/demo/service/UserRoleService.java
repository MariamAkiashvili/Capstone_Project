package com.capstoneProject.demo.service;

import com.capstoneProject.demo.dtos.UserRoleDTO;

import java.util.List;

public interface UserRoleService {
    UserRoleDTO findUserRoleByRoleCode(String roleCode);

    List<UserRoleDTO> getUserRoles();
}
