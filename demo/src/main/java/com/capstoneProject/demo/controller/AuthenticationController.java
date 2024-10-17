package com.capstoneProject.demo.controller;

import com.capstoneProject.demo.serviceImplementation.UserDetailServiceImpl;
import com.capstoneProject.demo.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailServiceImpl userDetailServiceImpl;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/login")
    public String createAuthenticationToken(@RequestParam String email, @RequestParam String password) throws Exception {
        try {
            // Authenticate the user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );
        } catch (AuthenticationException e) {
            throw new Exception("Incorrect email or password", e);
        }

        // Retrieve user details and generate JWT
        UserDetails userDetails = userDetailServiceImpl.loadUserByUsername(email);

        return jwtUtil.generateToken(userDetails);
    }
}
