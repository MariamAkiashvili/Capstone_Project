package com.capstoneProject.demo.serviceImplementation;

import com.capstoneProject.demo.convertors.FacultyConventor;
import com.capstoneProject.demo.dtos.FacultyDTO;
import com.capstoneProject.demo.entity.Faculty;
import com.capstoneProject.demo.repository.FacultyRepository;
import com.capstoneProject.demo.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    FacultyRepository facultyRepository;

    @Override
    public List<FacultyDTO> getAllFaculties(){
        List<Faculty> faculties = facultyRepository.findAll();
        return faculties.stream()
                .map(FacultyConventor::convertTo)
                .collect(Collectors.toList());
    }

    @Override
    public FacultyDTO addFaculty(FacultyDTO facultyDTO) {
        Faculty faculty = new Faculty();
        faculty.setCode(facultyDTO.getCode());
        faculty.setName(facultyDTO.getName());
        faculty.setDescription(facultyDTO.getDescription());

        facultyRepository.save(faculty);
        return facultyDTO;
    }

    @Override
    public void deleteFaculty(String code){
        facultyRepository.deleteById(code);
    }
}
