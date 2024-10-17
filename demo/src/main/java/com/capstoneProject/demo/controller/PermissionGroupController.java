package com.capstoneProject.demo.controller;

import com.amazonaws.Response;
import com.capstoneProject.demo.dtos.PermissionGroupDTO;
import com.capstoneProject.demo.serviceImplementation.PermissionGroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionGroupController {


    @Autowired
    private PermissionGroupServiceImpl permissionGroupService;

    @GetMapping("/access-type/{code}")
    public ResponseEntity<List<PermissionGroupDTO>> getPermissionsByAccessType(@PathVariable String code){
        List<PermissionGroupDTO> permissionGroupDTOS = permissionGroupService.getPermissionByAccessTypeCode(code);
        if(permissionGroupDTOS.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(permissionGroupDTOS);
    }

    @GetMapping("/user-role/{code}")
    public ResponseEntity<List<PermissionGroupDTO>> getPermissionsByUserRole(@PathVariable String code){
        List<PermissionGroupDTO> permissionGroupDTOS = permissionGroupService.getPermissionByUserRoleCode(code);
        if(permissionGroupDTOS.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(permissionGroupDTOS);
    }

    @PostMapping("/add-permission")
    public ResponseEntity<PermissionGroupDTO> createPermission(@Validated @RequestBody PermissionGroupDTO permissionGroupDTO){
        PermissionGroupDTO permissionGroupDTO1 = permissionGroupService.addPermission(permissionGroupDTO);

        if(permissionGroupDTO1 == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(201).body(permissionGroupDTO1);
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<Void> deletePermission(@PathVariable long id){
        permissionGroupService.deletePermission(id);
        return ResponseEntity.noContent().build();
    }
}
