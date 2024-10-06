package com.capstoneProject.demo.repository;

import com.capstoneProject.demo.dtos.UserRoleDTO;
import com.capstoneProject.demo.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, String> {
    UserRole findByUserRoleCode(String roleCode);
}
