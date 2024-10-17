package com.capstoneProject.demo.controller;

import com.capstoneProject.demo.dtos.StudentProfileDTO;
import com.capstoneProject.demo.serviceImplementation.StudentProfileServiceImpl;
import com.capstoneProject.demo.serviceImplementation.UniversityUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private StudentProfileServiceImpl studentProfileServiceImpl;

    @GetMapping("/{id}")
    public String getUserProfile(@PathVariable Long id, Model model) {
        StudentProfileDTO userProfile = studentProfileServiceImpl.getUserProfile(id);
        if (userProfile == null) {
            return "redirect:/error"; // Redirect to an error page if user is not found
        }
        model.addAttribute("user", userProfile);
        return "profile";
    }

    @PostMapping("/update-phone")
    public ResponseEntity<StudentProfileDTO> updatePhone (@RequestParam String phone,
                                        @RequestParam Long id){
        StudentProfileDTO studentProfileDTO = studentProfileServiceImpl.updatePhone(id, phone);
        if(studentProfileDTO == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(studentProfileDTO);
    }
}
