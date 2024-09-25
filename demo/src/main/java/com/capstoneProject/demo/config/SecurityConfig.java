package com.capstoneProject.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/css/**", "/img/**").permitAll()  // Permit access to static resources and home page
                        .anyRequest().authenticated()  // All other requests require authentication
                )
                .formLogin(form -> form
                        .loginPage("/login")  // Custom login page
                        .permitAll()  // Permit everyone to see the login page
                )
                .logout(LogoutConfigurer::permitAll);  // Allow logging out for all users


        return http.build();
    }
}
