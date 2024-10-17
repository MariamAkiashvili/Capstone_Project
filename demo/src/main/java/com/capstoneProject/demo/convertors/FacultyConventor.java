package com.capstoneProject.demo.convertors;

import com.capstoneProject.demo.dtos.FacultyDTO;
import com.capstoneProject.demo.entity.Faculty;

public class FacultyConventor {

    public static FacultyDTO convertTo(Faculty faculty){
        FacultyDTO facultyDTO = new FacultyDTO();
        facultyDTO.setCode(faculty.getCode());
        facultyDTO.setName(faculty.getName());
        facultyDTO.setDescription(faculty.getDescription());

        return facultyDTO;
    }
}
