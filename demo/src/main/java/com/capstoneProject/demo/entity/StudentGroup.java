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
    private Group group;

    @Column(name = "added_date", columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime addedDate;
}