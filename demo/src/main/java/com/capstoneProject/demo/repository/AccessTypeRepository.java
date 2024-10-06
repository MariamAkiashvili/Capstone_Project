package com.capstoneProject.demo.repository;

import com.capstoneProject.demo.entity.AccessType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessTypeRepository extends JpaRepository<AccessType, String> {
    AccessType findByAccessTypeCode(String code);
}
