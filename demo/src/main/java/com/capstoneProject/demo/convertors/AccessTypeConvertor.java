package com.capstoneProject.demo.convertors;

import com.capstoneProject.demo.dtos.AccessTypeDTO;
import com.capstoneProject.demo.entity.AccessType;

public class AccessTypeConvertor {
    public static AccessTypeDTO convertTo(AccessType accessType){
        AccessTypeDTO accessTypeDTO = new AccessTypeDTO();
        accessTypeDTO.setAccessTypeCode(accessType.getCode());
        accessTypeDTO.setName(accessType.getName());
        return accessTypeDTO;
    }
}
