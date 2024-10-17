package com.capstoneProject.demo.service;

import com.capstoneProject.demo.dtos.StudentGroupDTO;

import java.util.List;

public interface StudentGroupService {
    List<StudentGroupDTO> getAllStudentGroups();
    List<StudentGroupDTO> getStudentGroupsByStudentId(long id);
    List<StudentGroupDTO> getStudentGroupsByLecturerId(long id);
    List<StudentGroupDTO> getStudentGroupsByGroupId(long id);

    StudentGroupDTO addStudentGroup(StudentGroupDTO studentGroupDTO);
    void deleteStudentGroupById(long id);
}
