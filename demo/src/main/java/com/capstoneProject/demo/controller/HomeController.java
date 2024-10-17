package com.capstoneProject.demo.controller;

import com.capstoneProject.demo.serviceImplementation.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model, Authentication authentication) {
        // Check if the user is authenticated
        boolean isAuthenticated = authentication != null && authentication.isAuthenticated();

        String userRoleCode = "";

        // If the user is authenticated, retrieve the userRoleCode from the principal
        if (isAuthenticated) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            userRoleCode = userDetails.getUserRoleCode();  // Retrieve user role code
        }
        // Add attributes to the model to pass data to Thymeleaf
        model.addAttribute("message", "Welcome to Thymeleaf!");
        model.addAttribute("authenticated", isAuthenticated); // Add authentication status
        model.addAttribute("userRoleCode", userRoleCode);

        return "index";  // return the name of the Thymeleaf template (index.html)
    }
}
