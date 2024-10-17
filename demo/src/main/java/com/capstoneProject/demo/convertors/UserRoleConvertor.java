package com.capstoneProject.demo.convertors;

import com.capstoneProject.demo.dtos.UserRoleDTO;
import com.capstoneProject.demo.entity.UserRole;

public class UserRoleConvertor {
    public static UserRoleDTO convetTo(UserRole userRole){
        UserRoleDTO userRoleDTO = new UserRoleDTO();
        userRoleDTO.setUserRoleCode(userRole.getuserRoleCode());
        userRoleDTO.setUserRoleName(userRole.getUserRoleName());

        return userRoleDTO;
    }
}
