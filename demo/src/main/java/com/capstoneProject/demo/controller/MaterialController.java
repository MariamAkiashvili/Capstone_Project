package com.capstoneProject.demo.controller;


import com.capstoneProject.demo.dtos.MaterialDTO;
import com.capstoneProject.demo.dtos.UniversityUserDTO;
import com.capstoneProject.demo.serviceImplementation.MaterialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/material")
@CrossOrigin
public class MaterialController {

    @Autowired
    private MaterialServiceImpl materialServiceImpl;


    @GetMapping("/all")
    public ResponseEntity<List<MaterialDTO>> getAllMaterial() {
        List<MaterialDTO> materials = materialServiceImpl.getAllMaterials();
        if (materials.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(materials);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<MaterialDTO>> searchMaterials(
            @RequestParam(value = "q", required = false) String query,
            @PageableDefault(sort = {"materialName", "materialUploadDate"}) Pageable pageable) {

        Page<MaterialDTO> materialPage = materialServiceImpl.searchMaterials(query, pageable);
        return ResponseEntity.ok(materialPage);
    }


    @PostMapping("/upload-material")
    public ResponseEntity<MaterialDTO> uploadMaterial(@RequestParam("materialName") String materialName,
                                                      @RequestParam("description") String description,
                                                      @RequestParam("universityUserId") Long universityUserId,
                                                      @RequestParam(value = "link", required = false) String link,
                                                      @RequestParam(value = "isOnlineMaterial", defaultValue = "false") boolean isOnlineMaterial,
                                                      @RequestParam(value = "file", required = false) MultipartFile file) {

        MaterialDTO materialDTO = new MaterialDTO();
        materialDTO.setMaterialName(materialName);
        materialDTO.setDescription(description);
        materialDTO.setMaterialUploadDate(LocalDateTime.now());
        materialDTO.setIsOnlineMaterial(isOnlineMaterial);
        materialDTO.setLink(link);

        UniversityUserDTO universityUserDTO = new UniversityUserDTO();
        universityUserDTO.setUniversityUserId(universityUserId);
        materialDTO.setUniversityUser(universityUserDTO);

        if (!isOnlineMaterial && (file == null || file.isEmpty())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }


        MaterialDTO uploadedMaterial;


        uploadedMaterial = materialServiceImpl.uploadMaterial(materialDTO, file);


        if (uploadedMaterial == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(uploadedMaterial);

    }


    @DeleteMapping("/delete-material/id/{id}")
    public ResponseEntity<Void> deleteMaterialById(@PathVariable long id) {
        materialServiceImpl.deleteMaterial(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/public")
    public ResponseEntity<List<MaterialDTO>> getPublicMaterials() {
        List<MaterialDTO> materials = materialServiceImpl.getAllMaterials();
        if (materials.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(materials);
    }

    @PostMapping("upload")
    public ResponseEntity<Void> upload(@RequestParam("file") MultipartFile file) {
        System.out.println("get upload request");
        return ResponseEntity.ok(null);
    }


}
