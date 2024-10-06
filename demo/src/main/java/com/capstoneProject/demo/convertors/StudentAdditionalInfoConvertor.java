package com.capstoneProject.demo.convertors;

import com.capstoneProject.demo.dtos.StudentAdditionalInfoDTO;
import com.capstoneProject.demo.entity.StudentAdditionalInfo;

public class StudentAdditionalInfoConvertor {
    public static StudentAdditionalInfoDTO convertTo(StudentAdditionalInfo studentAdditionalInfo){
        StudentAdditionalInfoDTO studentAdditionalInfoDTO = new StudentAdditionalInfoDTO();
        studentAdditionalInfoDTO.setUniversityUser(UserConvertor.convertToDTO(studentAdditionalInfo.getUniversityUser()));
        studentAdditionalInfoDTO.setCourse(CourseConvertor.convertTo(studentAdditionalInfo.getCourse()));
        studentAdditionalInfoDTO.setCurrentStudyYear(studentAdditionalInfo.getCurrentStudyYear());
        studentAdditionalInfoDTO.setHasActiveStatus(studentAdditionalInfo.getHasActiveStatus());

        return studentAdditionalInfoDTO;
    }
}
