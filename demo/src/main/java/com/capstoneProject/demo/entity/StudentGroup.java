package com.capstoneProject.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "student_group")
public class StudentGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_group_id")
    private long studentGroupId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "university_user_id", nullable = false)
    private UniversityUser student;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "university_group_id", nullable = false)
    private Group universityGroup;

    @Column(name = "added_date", columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime addedDate;

    public long getStudentGroupId() {
        return studentGroupId;
    }

    public void setStudentGroupId(long studentGroupId) {
        this.studentGroupId = studentGroupId;
    }

    public UniversityUser getStudent() {
        return student;
    }

    public void setStudent(UniversityUser student) {
        this.student = student;
    }

    public Group getGroup() {
        return universityGroup;
    }

    public void setGroup(Group group) {
        this.universityGroup = group;
    }

    public LocalDateTime getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDateTime addedDate) {
        this.addedDate = addedDate;
    }
}