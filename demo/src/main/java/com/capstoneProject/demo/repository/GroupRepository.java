package com.capstoneProject.demo.repository;

import com.capstoneProject.demo.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
