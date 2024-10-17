package com.capstoneProject.demo.controller;


import com.capstoneProject.demo.dtos.UserRoleDTO;
import com.capstoneProject.demo.entity.UserRole;
import com.capstoneProject.demo.serviceImplementation.UserRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user-roles")
@CrossOrigin
public class UserRoleController {

    @Autowired
    private UserRoleServiceImpl userRoleServicelImpl;

    @GetMapping("/all")
    public ResponseEntity<List<UserRoleDTO>> getAllUserRoles(){
        List<UserRoleDTO> userRoles = userRoleServicelImpl.getUserRoles();
        if (userRoles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userRoles);
    }

}
