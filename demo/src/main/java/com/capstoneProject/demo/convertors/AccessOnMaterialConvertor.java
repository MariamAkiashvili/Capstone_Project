package com.capstoneProject.demo.convertors;

import com.capstoneProject.demo.controller.MaterialController;
import com.capstoneProject.demo.dtos.AccessOnMaterialDTO;
import com.capstoneProject.demo.entity.AccessOnMaterial;

public class AccessOnMaterialConvertor {
    public static AccessOnMaterialDTO convertTo(AccessOnMaterial accessOnMaterial){
        AccessOnMaterialDTO accessOnMaterialDTO = new AccessOnMaterialDTO();
        accessOnMaterialDTO.setAccessOnMaterialId(accessOnMaterial.getAccessOnMaterialId());
        accessOnMaterialDTO.setAccessType(AccessTypeConvertor.convertTo(accessOnMaterial.getAccessType()));
        accessOnMaterialDTO.setMaterial(MaterialConvertor.convertToDTO(accessOnMaterial.getMaterial()));
        accessOnMaterialDTO.setGroup(GroupConvertor.convertTo(accessOnMaterial.getGroup()));

        return accessOnMaterialDTO;
    }
}
