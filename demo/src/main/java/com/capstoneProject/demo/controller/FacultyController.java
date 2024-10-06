package com.capstoneProject.demo.controller;


import com.capstoneProject.demo.dtos.FacultyDTO;
import com.capstoneProject.demo.serviceImplementation.FacultyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyServiceImpl facultyServiceImpl;

    @GetMapping("/all")
    public ResponseEntity<List<FacultyDTO>> getAllFaculties(){
        List<FacultyDTO> facultyDTOS = facultyServiceImpl.getAllFaculties();
        if (facultyDTOS.isEmpty()) {
            return ResponseEntity.noContent().build(); // or return an empty 200 list
        }
        return ResponseEntity.ok(facultyDTOS);
    }

    @PostMapping("/add-faculty")
    public ResponseEntity<FacultyDTO> addFaculty(@Validated @RequestBody FacultyDTO facultyDTO){
        facultyServiceImpl.addFaculty(facultyDTO);
        return ResponseEntity.status(201).body(facultyDTO);
    }

    @DeleteMapping("/delete-faculty/code/{code}")
    public ResponseEntity<Void> deleteFacultyById(@PathVariable String code){
        facultyServiceImpl.deleteFaculty(code);
        return ResponseEntity.noContent().build();
    }
}
