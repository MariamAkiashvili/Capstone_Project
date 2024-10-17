package com.capstoneProject.demo.repository;

import com.capstoneProject.demo.entity.PermissionGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionGroupRepository extends JpaRepository<PermissionGroup, Long> {
    List<PermissionGroup> findByUserRoleCode_UserRoleCode(String userRoleCode);

    List<PermissionGroup> findByAccessTypeCode_AccessTypeCode(String accessTypeCode);
}
