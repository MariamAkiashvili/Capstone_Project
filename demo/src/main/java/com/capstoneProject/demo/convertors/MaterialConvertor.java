package com.capstoneProject.demo.convertors;

import com.capstoneProject.demo.dtos.MaterialDTO;
import com.capstoneProject.demo.entity.Material;
import com.capstoneProject.demo.convertors.UserConvertor;

public class MaterialConvertor {
    public static MaterialDTO convertToDTO(Material material) {
        MaterialDTO materialDTO = new MaterialDTO();
        materialDTO.setMaterialId(material.getMaterialId());
        materialDTO.setMaterialName(material.getMaterialName());
        materialDTO.setDescription(material.getDescription());
        materialDTO.setMaterial_update_date(material.getMaterial_update_date());
        materialDTO.setMaterialUploadDate(material.getMaterialUploadDate());
        materialDTO.setUniversityUser(UserConvertor.convertToDTO(material.getUniversityUser()));
        materialDTO.setLink(material.getLink());
        return materialDTO;

    }
}
