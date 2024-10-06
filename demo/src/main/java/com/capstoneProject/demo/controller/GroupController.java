package com.capstoneProject.demo.controller;

import com.capstoneProject.demo.dtos.GroupDTO;
import com.capstoneProject.demo.serviceImplementation.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
@CrossOrigin
public class GroupController {

    @Autowired
    private GroupServiceImpl groupServiceImpl;

    @GetMapping("/all")
    public ResponseEntity<List<GroupDTO>> getAllGroups(){
        List<GroupDTO> groupDTOS = groupServiceImpl.getAllGroups();
        if(groupDTOS == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(groupDTOS);
    }

    @PostMapping("/add-group")
    public ResponseEntity<GroupDTO> createGroup(@Validated @RequestBody GroupDTO groupDTO){
        groupServiceImpl.addGroup(groupDTO);
        return ResponseEntity.ok(groupDTO);
    }

    @DeleteMapping("delete-group/id/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable long id){
        groupServiceImpl.deleteGroup(id);
        return ResponseEntity.noContent().build();
    }
}
