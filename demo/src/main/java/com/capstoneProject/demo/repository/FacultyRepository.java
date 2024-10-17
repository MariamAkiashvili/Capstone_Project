package com.capstoneProject.demo.repository;

import com.capstoneProject.demo.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty, String> {

    Optional<Faculty> findByCode(String code);
}
