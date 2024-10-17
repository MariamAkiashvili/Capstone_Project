package com.capstoneProject.demo.convertors;

import com.capstoneProject.demo.dtos.UniversityUserDTO;
import com.capstoneProject.demo.entity.UniversityUser;

public class UserConvertor {
    public static UniversityUserDTO convertToDTO(UniversityUser universityUser){
        UniversityUserDTO dto = new UniversityUserDTO();
        dto.setUniversityUserId(universityUser.getId());
        dto.setFirstName(universityUser.getFirstName());
        dto.setLastName(universityUser.getLastName());
        dto.setEmail(universityUser.getEmail());
        dto.setUserRoleCode(universityUser.getUserRole_code().getuserRoleCode());
        return dto;
    }
}
