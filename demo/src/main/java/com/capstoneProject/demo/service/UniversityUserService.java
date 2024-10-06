package com.capstoneProject.demo.service;


import com.capstoneProject.demo.dtos.UniversityUserDTO;
import com.capstoneProject.demo.entity.UniversityUser;
import com.capstoneProject.demo.user.UserDTO;

import java.util.List;

public interface UniversityUserService {


    List<UniversityUserDTO> getAllUniversityUsers();

    UniversityUserDTO getUniversityUserById(Long id);

    List<UniversityUserDTO> getUniversityUsersByRole(String role);

    UniversityUserDTO createUniversityUser(UserDTO universityUser);

    void deleteUniversityUser(Long id);

}
