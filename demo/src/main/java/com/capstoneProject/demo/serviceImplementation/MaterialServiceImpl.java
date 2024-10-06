package com.capstoneProject.demo.serviceImplementation;

import com.capstoneProject.demo.convertors.MaterialConvertor;
import com.capstoneProject.demo.dtos.MaterialDTO;
import com.capstoneProject.demo.entity.Material;
import com.capstoneProject.demo.entity.UniversityUser;
import com.capstoneProject.demo.fileUpload.AWSS3Util;
import com.capstoneProject.demo.repository.MaterialRepository;
import com.capstoneProject.demo.repository.UniversityUserRepository;
import com.capstoneProject.demo.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    MaterialRepository materialRepository;

    @Autowired
    UniversityUserRepository universityUserRepository;

    @Autowired
    private AWSS3Util awss3Util;


    @Override
    public List<MaterialDTO> getAllMaterials() {
        List<Material> materials = materialRepository.findAll();
        return materials
                .stream()
                .map(MaterialConvertor::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<MaterialDTO> searchMaterials(String query, Pageable pageable) {
        Specification<Material> specification = Specification.where(null);

        if (query != null && !query.isEmpty()) {

            String[] filters = query.split(";");
            for (String filter : filters) {
                String[] parts = filter.split("==");
                if (parts.length == 2) {
                    specification = switch (parts[0]) {
                        case "materialName" -> specification.and((root, cq, cb) ->
                                cb.like(root.get("materialName"), "%" + parts[1] + "%")); // Handle LIKE search
                        case "uploadedByUserId" -> {
                            Long userId = Long.parseLong(parts[1]);
                            yield specification.and((root, cq, cb) ->
                                    cb.equal(root.get("uploadedByUserId").get("universityUserId"), userId));
                        }
                        default -> specification;
                    };
                }
            }
        }

        Page<Material> materialPage = materialRepository.findAll(specification, pageable);

        return materialPage.map(MaterialConvertor::convertToDTO);
    }

    @Override
    public MaterialDTO uploadMaterial(MaterialDTO materialDTO, MultipartFile file) {
        Material material = new Material();
        material.setMaterialName(materialDTO.getMaterialName());
        material.setDescription(materialDTO.getDescription());
        material.setMaterialUploadDate(materialDTO.getMaterialUploadDate());
        material.setMaterial_update_date(materialDTO.getMaterial_update_date());

        if (file != null && !file.isEmpty()) {
            String fileUrl = null;
            fileUrl = awss3Util.uploadDocumentToS3(file.getOriginalFilename(), file);
            material.setS3Address(fileUrl);
        } else {
            material.setLink(materialDTO.getLink());
        }


        Optional<UniversityUser> optionalUser
                = universityUserRepository.findById(materialDTO.getUniversityUser().getUniversityUserId());

        if (optionalUser.isPresent()) {
            UniversityUser universityUser = optionalUser.get();
            material.setUniversityUser(universityUser);

            materialRepository.save(material);
        } else {
            return null;
        }


        return materialDTO;
    }

    @Override
    public void deleteMaterial(long id) {
        materialRepository.deleteById(id);
    }


}
