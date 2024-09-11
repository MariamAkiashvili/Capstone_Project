package com.capstoneProject.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/").permitAll()  // Allow access to the home page
                                .anyRequest().authenticated()       // Other endpoints require authentication
                )
                .formLogin(withDefaults())  // Enable form login with default configuration
                .logout(withDefaults());    // Enable logout with default configuration

        return http.build();
    }
}
