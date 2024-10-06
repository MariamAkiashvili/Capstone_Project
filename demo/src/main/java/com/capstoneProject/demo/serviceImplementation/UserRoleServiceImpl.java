package com.capstoneProject.demo.serviceImplementation;

import com.capstoneProject.demo.convertors.UserRoleConvertor;
import com.capstoneProject.demo.dtos.UserRoleDTO;
import com.capstoneProject.demo.entity.UserRole;
import com.capstoneProject.demo.repository.UserRoleRepository;
import com.capstoneProject.demo.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserRoleDTO findUserRoleByRoleCode(String roleCode) {
        return UserRoleConvertor.convetTo(userRoleRepository.findByUserRoleCode(roleCode));
    }

    @Override
    public List<UserRoleDTO> getUserRoles() {
        List<UserRole> userRoles = userRoleRepository.findAll();

        return userRoles.stream()
                .map(UserRoleConvertor::convetTo)
                .collect(Collectors.toList());
    }
}
