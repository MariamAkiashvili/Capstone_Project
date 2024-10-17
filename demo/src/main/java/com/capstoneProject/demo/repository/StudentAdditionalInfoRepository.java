package com.capstoneProject.demo.repository;

import com.capstoneProject.demo.entity.StudentAdditionalInfo;
import com.capstoneProject.demo.entity.UniversityUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentAdditionalInfoRepository extends JpaRepository<StudentAdditionalInfo, Long> {
    Optional<StudentAdditionalInfo> findByUniversityUser(UniversityUser user);
}
