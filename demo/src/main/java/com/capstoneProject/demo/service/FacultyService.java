package com.capstoneProject.demo.service;

import com.capstoneProject.demo.dtos.FacultyDTO;

import java.util.List;

public interface FacultyService {
    List<FacultyDTO> getAllFaculties();
    FacultyDTO addFaculty(FacultyDTO facultyDTO);
    void deleteFaculty(String code);
}
