package com.capstoneProject.demo.service;

import com.capstoneProject.demo.dtos.MaterialDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

public interface MaterialService {
    List<MaterialDTO> getAllMaterials();

    Page<MaterialDTO> searchMaterials(String query, Pageable pageable);

    MaterialDTO uploadMaterial(MaterialDTO materialDTO, MultipartFile file);

    void deleteMaterial(long id);
}

