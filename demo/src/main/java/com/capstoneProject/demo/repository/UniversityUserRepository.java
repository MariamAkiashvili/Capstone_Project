package com.capstoneProject.demo.repository;

import com.capstoneProject.demo.dtos.UniversityUserDTO;
import com.capstoneProject.demo.entity.UniversityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityUserRepository extends JpaRepository<UniversityUser, Long> {
    List<UniversityUser> findByUserRoleCode_UserRoleCode(String role);

    UniversityUser findOneByEmail(String email);
}
