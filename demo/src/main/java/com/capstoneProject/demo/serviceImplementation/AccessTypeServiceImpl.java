package com.capstoneProject.demo.serviceImplementation;

import com.capstoneProject.demo.convertors.AccessTypeConvertor;
import com.capstoneProject.demo.dtos.AccessTypeDTO;
import com.capstoneProject.demo.entity.AccessType;
import com.capstoneProject.demo.repository.AccessTypeRepository;
import com.capstoneProject.demo.service.AccessTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccessTypeServiceImpl implements AccessTypeService {

    @Autowired
    AccessTypeRepository accessTypeRepository;

    @Override
    public List<AccessTypeDTO> getAllAccessType() {
        List<AccessType> accessTypes = accessTypeRepository.findAll();
        return accessTypes.stream()
                .map(AccessTypeConvertor::convertTo)
                .collect(Collectors.toList());
    }
}
