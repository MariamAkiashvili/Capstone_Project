package com.capstoneProject.demo.serviceImplementation;

import com.capstoneProject.demo.convertors.PermissionGroupConvertor;
import com.capstoneProject.demo.dtos.PermissionGroupDTO;
import com.capstoneProject.demo.entity.AccessType;
import com.capstoneProject.demo.entity.PermissionGroup;
import com.capstoneProject.demo.entity.UserRole;
import com.capstoneProject.demo.repository.AccessTypeRepository;
import com.capstoneProject.demo.repository.PermissionGroupRepository;
import com.capstoneProject.demo.repository.UserRoleRepository;
import com.capstoneProject.demo.service.PermissionGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PermissionGroupServiceImpl implements PermissionGroupService {

    @Autowired
    private PermissionGroupRepository permissionGroupRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private AccessTypeRepository accessTypeRepository;


    @Override
    public List<PermissionGroupDTO> getPermissionByUserRoleCode(String userRoleCode) {
        List<PermissionGroup> permissionGroups = permissionGroupRepository.findByUserRoleCode_UserRoleCode(userRoleCode);
        return permissionGroups.stream()
                .map(PermissionGroupConvertor::convertTo)
                .collect(Collectors.toList());
    }

    @Override
    public List<PermissionGroupDTO> getPermissionByAccessTypeCode(String accessTypeCode) {
        List<PermissionGroup> permissionGroups = permissionGroupRepository.findByAccessTypeCode_AccessTypeCode(accessTypeCode);
        return permissionGroups.stream()
                .map(PermissionGroupConvertor::convertTo)
                .collect(Collectors.toList());
    }

    @Override
    public PermissionGroupDTO addPermission(PermissionGroupDTO permissionGroupDTO) {
        UserRole userRole = userRoleRepository.findByUserRoleCode(permissionGroupDTO.getUserRoleCode().getUserRoleCode());
        AccessType accessType = accessTypeRepository.findByAccessTypeCode(permissionGroupDTO.getAccessType().getAccessTypeCode());

        if(userRole == null || accessType == null){
            return null;
        }

        PermissionGroup permissionGroup = new PermissionGroup();
        permissionGroup.setAccessType(accessType);
        permissionGroup.setUserRoleCode(userRole);

        permissionGroupRepository.save(permissionGroup);

        return permissionGroupDTO;
    }

    @Override
    public void deletePermission(long id) {
        permissionGroupRepository.deleteById(id);
    }
}
