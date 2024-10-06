package com.capstoneProject.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        // Add attributes to the model to pass data to Thymeleaf
        model.addAttribute("message", "Welcome to Thymeleaf!");
        return "index";  // return the name of the Thymeleaf template (index.html)
    }
}
