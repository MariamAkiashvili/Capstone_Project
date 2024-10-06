package com.capstoneProject.demo.repository;

import com.capstoneProject.demo.entity.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentGroupRepository extends JpaRepository<StudentGroup, Long> {
    List<StudentGroup> findByStudent_UniversityUserId(long id);

    List<StudentGroup> findByUniversityGroup_UniversityGroupId(long groupId);

}
