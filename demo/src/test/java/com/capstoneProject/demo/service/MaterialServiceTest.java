package com.capstoneProject.demo.service;

import com.capstoneProject.demo.convertors.MaterialConvertor;
import com.capstoneProject.demo.dtos.MaterialDTO;
import com.capstoneProject.demo.dtos.UniversityUserDTO;
import com.capstoneProject.demo.entity.Material;
import com.capstoneProject.demo.entity.UniversityUser;
import com.capstoneProject.demo.entity.UserRole;
import com.capstoneProject.demo.fileUpload.AWSS3Util;
import com.capstoneProject.demo.repository.MaterialRepository;
import com.capstoneProject.demo.repository.UniversityUserRepository;
import com.capstoneProject.demo.serviceImplementation.MaterialServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MaterialServiceImplTests {

    @Mock
    private MaterialRepository materialRepository;

    @Mock
    private UniversityUserRepository universityUserRepository;

    @Mock
    private AWSS3Util awss3Util;

    @InjectMocks
    private MaterialServiceImpl materialService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initializes @Mock and @InjectMocks
    }

    @Test
    void testGetAllMaterials() {

        Material material = new Material();
        material.setMaterialName("Test Material");


        UniversityUser universityUser = new UniversityUser();
        universityUser.setUniversityUserId(1L);

        UserRole userRole = new UserRole();
        userRole.setCode("STUDENT");
        universityUser.setUserRole_code(userRole);

        material.setUniversityUser(universityUser);

        when(materialRepository.findAll()).thenReturn(Arrays.asList(material));

        // Act
        List<MaterialDTO> materialDTOs = materialService.getAllMaterials();

        // Assert
        assertNotNull(materialDTOs);
        assertEquals(1, materialDTOs.size());
        assertEquals("Test Material", materialDTOs.get(0).getMaterialName());
        assertEquals(1L, materialDTOs.get(0).getUniversityUser().getUniversityUserId()); // Verify the universityUserId
        verify(materialRepository, times(1)).findAll();
    }


    @Test
    void testSearchMaterials() {

        Material material = new Material();
        material.setMaterialName("Search Material");

        UniversityUser universityUser = new UniversityUser();
        universityUser.setUniversityUserId(1L);

        // Initialize and set UserRole for the universityUser
        UserRole userRole = new UserRole();
        userRole.setCode("STUDENT");
        universityUser.setUserRole_code(userRole); // Set UserRole in UniversityUser

        material.setUniversityUser(universityUser);

        Pageable pageable = PageRequest.of(0, 10);
        Page<Material> page = new PageImpl<>(Arrays.asList(material));

        when(materialRepository.findAll(any(Specification.class), any(Pageable.class)))
                .thenReturn(page);

        // Act
        Page<MaterialDTO> materialDTOPage = materialService.searchMaterials("materialName==Search", pageable);

        // Assert
        assertNotNull(materialDTOPage);
        assertEquals(1, materialDTOPage.getTotalElements());
        assertEquals("Search Material", materialDTOPage.getContent().get(0).getMaterialName());
        verify(materialRepository, times(1)).findAll(any(Specification.class), eq(pageable));
    }



    @Test
    void testUploadMaterialWithFile() throws Exception {
        // Arrange
        MaterialDTO materialDTO = new MaterialDTO();
        materialDTO.setMaterialName("Uploaded Material");

        // Create and set a valid UniversityUserDTO
        UniversityUserDTO universityUserDTO = new UniversityUserDTO();
        universityUserDTO.setUniversityUserId(1L);
        materialDTO.setUniversityUser(universityUserDTO);

        MultipartFile file = mock(MultipartFile.class);
        when(file.getOriginalFilename()).thenReturn("test-file.pdf");
        when(file.isEmpty()).thenReturn(false);
        when(awss3Util.uploadDocumentToS3(anyString(), any(MultipartFile.class))).thenReturn("test-s3-url");

        UniversityUser universityUser = new UniversityUser();
        when(universityUserRepository.findById(anyLong())).thenReturn(Optional.of(universityUser));

        // Act
        MaterialDTO result = materialService.uploadMaterial(materialDTO, file);

        // Assert
        assertNotNull(result);
        verify(awss3Util, times(1)).uploadDocumentToS3(anyString(), eq(file));
        verify(materialRepository, times(1)).save(any(Material.class));
    }


    @Test
    void testUploadMaterialWithoutFile() {
        // Arrange
        MaterialDTO materialDTO = new MaterialDTO();
        materialDTO.setMaterialName("Online Material");
        materialDTO.setLink("http://example.com");


        UniversityUserDTO universityUserDTO = new UniversityUserDTO();
        universityUserDTO.setUniversityUserId(1L);
        materialDTO.setUniversityUser(universityUserDTO);


        when(universityUserRepository.findById(anyLong())).thenReturn(Optional.of(new UniversityUser()));

        MaterialDTO result = materialService.uploadMaterial(materialDTO, null);

        assertNotNull(result);
        verify(materialRepository, times(1)).save(any(Material.class));
        verify(awss3Util, never()).uploadDocumentToS3(anyString(), any(MultipartFile.class));
    }

    @Test
    void testDeleteMaterial() {
        long materialId = 1L;

        materialService.deleteMaterial(materialId);

        verify(materialRepository, times(1)).deleteById(materialId);
    }
}
