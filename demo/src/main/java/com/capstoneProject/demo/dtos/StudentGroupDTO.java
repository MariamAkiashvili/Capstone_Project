package com.capstoneProject.demo.dtos;

import com.capstoneProject.demo.entity.Group;
import com.capstoneProject.demo.entity.UniversityUser;

import java.time.LocalDateTime;

public class StudentGroupDTO {
    private long studentGroupId;
    private UniversityUserDTO student;
    private GroupDTO group;
    private LocalDateTime addedDate;

    public long getStudentGroupId() {
        return studentGroupId;
    }

    public void setStudentGroupId(long studentGroupId) {
        this.studentGroupId = studentGroupId;
    }

    public UniversityUserDTO getStudent() {
        return student;
    }

    public void setStudent(UniversityUserDTO student) {
        this.student = student;
    }

    public GroupDTO getGroup() {
        return group;
    }

    public void setGroup(GroupDTO group) {
        this.group = group;
    }

    public LocalDateTime getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDateTime addedDate) {
        this.addedDate = addedDate;
    }
}
