package com.capstoneProject.demo.controller;

import com.capstoneProject.demo.dtos.AccessTypeDTO;
import com.capstoneProject.demo.serviceImplementation.AccessTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/access-type")
public class AccessTypeController {
    @Autowired
    private AccessTypeServiceImpl accessTypeService;

    @GetMapping("/all")
    public ResponseEntity<List<AccessTypeDTO>> getAllAccessType(){
        List<AccessTypeDTO> accessTypeDTOS = accessTypeService.getAllAccessType();
        if(accessTypeDTOS.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(accessTypeDTOS);
    }





}
