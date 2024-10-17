package com.capstoneProject.demo.convertors;

import com.capstoneProject.demo.dtos.StudentGroupDTO;
import com.capstoneProject.demo.entity.StudentGroup;

public class StudentGroupConvertor {
    public static StudentGroupDTO convertTo(StudentGroup studentGroup){
        StudentGroupDTO studentGroupDTO = new StudentGroupDTO();
        studentGroupDTO.setStudent(UserConvertor.convertToDTO(studentGroup.getStudent()));
        studentGroupDTO.setGroup(GroupConvertor.convertTo(studentGroup.getGroup()));
        studentGroupDTO.setStudentGroupId(studentGroup.getStudentGroupId());
        studentGroupDTO.setAddedDate(studentGroup.getAddedDate());

        return studentGroupDTO;
    }
}
