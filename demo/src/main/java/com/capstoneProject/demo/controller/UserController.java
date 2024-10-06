package com.capstoneProject.demo.controller;


import com.capstoneProject.demo.dtos.UniversityUserDTO;
import com.capstoneProject.demo.serviceImplementation.UniversityUserServiceImpl;
import com.capstoneProject.demo.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university-users")
@CrossOrigin
public class UserController {


    @Autowired
    private UniversityUserServiceImpl universityUserServiceImpl;

    @GetMapping
    public ResponseEntity<List<UniversityUserDTO>> getAllUniversityUsers() {
        List<UniversityUserDTO> users = universityUserServiceImpl.getAllUniversityUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UniversityUserDTO> getUniversityUserById(@PathVariable Long id) {
        UniversityUserDTO user = universityUserServiceImpl.getUniversityUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<UniversityUserDTO>> getUniversityUserByRole(@PathVariable String role) {
        List<UniversityUserDTO> users = universityUserServiceImpl.getUniversityUsersByRole(role);
        if (users == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(users);
    }

    @PostMapping("/add-user")
    public ResponseEntity<UniversityUserDTO> createUniversityUser(@Validated @RequestBody UserDTO userDTO) {

        UniversityUserDTO createdUser = universityUserServiceImpl.createUniversityUser(userDTO);
        if (createdUser == null) {
            return ResponseEntity.status(409).body(null);
        }
        return ResponseEntity.status(201).body(createdUser);
    }

    @DeleteMapping("delete-user/id/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable long id) {
        universityUserServiceImpl.deleteUniversityUser(id);
        return ResponseEntity.noContent().build();
    }
}
