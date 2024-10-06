package com.capstoneProject.demo.controller;

import com.capstoneProject.demo.dtos.StudentGroupDTO;
import com.capstoneProject.demo.serviceImplementation.StudentGroupServiceImpl;
import org.aspectj.weaver.ResolvedPointcutDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-group")
@CrossOrigin
public class StudentGroupController {
    @Autowired
    private StudentGroupServiceImpl studentGroupServiceImpl;

    @GetMapping("/all")
    public ResponseEntity<List<StudentGroupDTO>> getAllStudentGroupRecords(){
        List<StudentGroupDTO> studentGroupDTOS = studentGroupServiceImpl.getAllStudentGroups();
        if(studentGroupDTOS.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentGroupDTOS);
    }

    @GetMapping("/studentId/{id}")
    public ResponseEntity<List<StudentGroupDTO>> getStudentGroupsByStudentId(@PathVariable long id){
        List<StudentGroupDTO> studentGroupDTOS = studentGroupServiceImpl.getStudentGroupsByStudentId(id);
        if(studentGroupDTOS.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentGroupDTOS);
    }

    @GetMapping("/groupId/{id}")
    public ResponseEntity<List<StudentGroupDTO>> getStudentGroupsByGroupId(@PathVariable long id){
        List<StudentGroupDTO> studentGroupDTOS = studentGroupServiceImpl.getStudentGroupsByGroupId(id);
        if(studentGroupDTOS.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentGroupDTOS);
    }

    @PostMapping("/add-student-in-group")
    public ResponseEntity<StudentGroupDTO> addStudentInGroup(@Validated @RequestBody StudentGroupDTO studentGroupDTO){
        StudentGroupDTO studentGroupDTO1 = studentGroupServiceImpl.addStudentGroup(studentGroupDTO);
        if(studentGroupDTO1 == null){
            return ResponseEntity.status(409).body(null);
        }
        return ResponseEntity.status(201).body(studentGroupDTO);
    }

    @DeleteMapping("/student-group-id/{id}")
    public ResponseEntity<Void> deleteStudentGroup(@PathVariable long id){
        studentGroupServiceImpl.deleteStudentGroupById(id);
        return ResponseEntity.noContent().build();
    }


}
