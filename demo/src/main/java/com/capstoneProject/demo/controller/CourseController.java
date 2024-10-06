package com.capstoneProject.demo.controller;

import com.capstoneProject.demo.dtos.CourseDTO;
import com.capstoneProject.demo.serviceImplementation.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseController {

    @Autowired
    private CourseServiceImpl courseServiceImpl;


    @GetMapping("/all")
    public ResponseEntity<List<CourseDTO>> getAllCourse(){
        List<CourseDTO> courseDTOS = courseServiceImpl.getAllCourse();
        if(courseDTOS == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(courseDTOS);
    }

    @PostMapping("/add-course")
    public ResponseEntity<CourseDTO> createCourse(@Validated @RequestBody CourseDTO courseDTO){
        CourseDTO courseDTO1 = courseServiceImpl.addCurse(courseDTO);
        if(courseDTO1 == null){
            return ResponseEntity.status(409).body(null);
        }
        return ResponseEntity.ok(courseDTO1);
    }

    @DeleteMapping("delete-course/id/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable long id){
        courseServiceImpl.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }


}
