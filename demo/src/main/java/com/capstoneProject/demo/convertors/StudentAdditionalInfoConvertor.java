package com.capstoneProject.demo.convertors;

import com.capstoneProject.demo.dtos.StudentAdditionalInfoDTO;
import com.capstoneProject.demo.entity.StudentAdditionalInfo;

public class StudentAdditionalInfoConvertor {
    public static StudentAdditionalInfoDTO convertTo(StudentAdditionalInfo studentAdditionalInfo){
        StudentAdditionalInfoDTO studentAdditionalInfoDTO = new StudentAdditionalInfoDTO();
        studentAdditionalInfoDTO.setUniversityUser(UserConvertor.convertToDTO(studentAdditionalInfo.getUniversityUser()));
        studentAdditionalInfoDTO.setFaculty(FacultyConventor.convertTo(studentAdditionalInfo.getFaculty()));
        studentAdditionalInfoDTO.setCurrentStudyYear(studentAdditionalInfo.getCurrentStudyYear());
        studentAdditionalInfoDTO.setHasActiveStatus(studentAdditionalInfo.getHasActiveStatus());
        studentAdditionalInfoDTO.setPhone(studentAdditionalInfo.getPhone());

        return studentAdditionalInfoDTO;
    }
}
