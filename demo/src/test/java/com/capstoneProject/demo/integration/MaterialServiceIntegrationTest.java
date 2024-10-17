package com.capstoneProject.demo.integration;

import com.capstoneProject.demo.dtos.MaterialDTO;
import com.capstoneProject.demo.dtos.UniversityUserDTO;
import com.capstoneProject.demo.entity.Material;
import com.capstoneProject.demo.entity.UniversityUser;
import com.capstoneProject.demo.entity.UserRole;
import com.capstoneProject.demo.repository.MaterialRepository;
import com.capstoneProject.demo.repository.UniversityUserRepository;
import com.capstoneProject.demo.repository.UserRoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureMockMvc
@Sql(scripts = {"/schema.sql", "/data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class MaterialServiceIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private UniversityUserRepository universityUserRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @BeforeEach
    public void setUp() {
        materialRepository.deleteAll(); // Clear previous material data
        universityUserRepository.deleteAll(); // Clear previous university user data
        userRoleRepository.deleteAll(); // Clear previous user role data
    }

    @Test
    public void testCreateMaterial() {
        // Create and save a user role
        UserRole role = new UserRole();
        role.setCode("admin");
        role.setName("Administrator");
        userRoleRepository.save(role);

        // Create and save a university user
        UniversityUser user = new UniversityUser();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        user.setUserRole_code(role); // Use appropriate method to set role code
        user.setPassword("securePassword");
        universityUserRepository.save(user);

        // Create a new MaterialDTO
        MaterialDTO newMaterial = new MaterialDTO();
        newMaterial.setMaterialName("New Material");
        newMaterial.setDescription("Description for new material.");
        newMaterial.setUniversityUser(new UniversityUserDTO());
        newMaterial.getUniversityUser().setUniversityUserId(user.getId());
        newMaterial.setLink("http://example.com/materials/new-material");
        newMaterial.setS3Address("s3://bucket/path/new-material");
        newMaterial.setIsOnlineMaterial(false);

        // Call the service to save the new material
        Material material = new Material();
        material.setMaterialName(newMaterial.getMaterialName());
        material.setDescription(newMaterial.getDescription());
        material.setLink(newMaterial.getLink());
        material.setS3Address(newMaterial.getS3Address());
        material.setIsOnlineMaterial(newMaterial.getIsOnlineMaterial());
        material.setUniversityUser(user);
        material.setMaterialUploadDate(LocalDateTime.now());

        Material savedMaterial = materialRepository.save(material);

        assertThat(savedMaterial).isNotNull();
        assertThat(savedMaterial.getMaterialName()).isEqualTo("New Material");
        assertThat(savedMaterial.getDescription()).isEqualTo("Description for new material.");
        assertThat(savedMaterial.getUniversityUser()).isEqualTo(user);
    }

    @Test
    public void testGetAllMaterials() {
        // Create and save a user role
        UserRole role = new UserRole();
        role.setCode("student");
        role.setName("Student");
        userRoleRepository.save(role);

        // Create and save a university user
        UniversityUser user = new UniversityUser();
        user.setFirstName("Jane");
        user.setLastName("Smith");
        user.setEmail("jane.smith@example.com");
        user.setUserRole_code(role); // Set the user's role
        user.setPassword("securePassword");
        universityUserRepository.save(user);

        // Create a material
        Material material = new Material();
        material.setMaterialName("Sample Material");
        material.setDescription("Sample description");
        material.setUniversityUser(user); // Use user directly
        material.setLink("http://example.com/sample");
        material.setS3Address("s3://bucket/path/sample");
        material.setMaterialUploadDate(LocalDateTime.now());
        materialRepository.save(material);

        List<Material> materials = materialRepository.findAll();

        assertThat(materials).isNotNull();
        assertThat(materials.size()).isGreaterThan(0);
    }

    @Test
    public void testUpdateMaterial() {
        // Create and save a user role
        UserRole role = new UserRole();
        role.setCode("faculty");
        role.setName("Faculty");
        userRoleRepository.save(role);

        // Create and save a university user
        UniversityUser user = new UniversityUser();
        user.setFirstName("Mark");
        user.setLastName("Johnson");
        user.setEmail("mark.johnson@example.com");
        user.setUserRole_code(role); // Set the user's role
        user.setPassword("securePassword");
        universityUserRepository.save(user);

        // Create and save a material
        Material material = new Material();
        material.setMaterialName("Original Material");
        material.setDescription("Original Description");
        material.setUniversityUser(user);
        material.setLink("http://example.com/original");
        material.setS3Address("s3://bucket/path/original");
        material.setMaterialUploadDate(LocalDateTime.now());
        materialRepository.save(material);

        // Update the material
        Material foundMaterial = materialRepository.findById(material.getMaterialId()).orElseThrow();
        foundMaterial.setMaterialName("Updated Material");
        materialRepository.save(foundMaterial);

        Material updatedMaterial = materialRepository.findById(foundMaterial.getMaterialId()).orElseThrow();
        assertThat(updatedMaterial.getMaterialName()).isEqualTo("Updated Material");
    }

    @Test
    public void testDeleteMaterial() {
        // Create and save a user role
        UserRole role = new UserRole();
        role.setCode("student");
        role.setName("Student");
        userRoleRepository.save(role);

        // Create and save a university user
        UniversityUser user = new UniversityUser();
        user.setFirstName("Emily");
        user.setLastName("Davis");
        user.setEmail("emily.davis@example.com");
        user.setUserRole_code(role); // Set the user's role
        user.setPassword("securePassword");
        universityUserRepository.save(user);

        // Create and save a material
        Material material = new Material();
        material.setMaterialName("Material to be deleted");
        material.setDescription("Description");
        material.setUniversityUser(user);
        material.setLink("http://example.com/to-be-deleted");
        material.setS3Address("s3://bucket/path/to-be-deleted");
        material.setMaterialUploadDate(LocalDateTime.now());
        materialRepository.save(material);

        // Delete the material
        materialRepository.deleteById(material.getMaterialId());

        // Verify it's deleted
        assertThat(materialRepository.findById(material.getMaterialId())).isEmpty();
    }

    @Test
    public void testUploadMaterial() throws Exception {
        // Create and save a user role
        UserRole role = new UserRole();
        role.setCode("admin");
        role.setName("Administrator");
        userRoleRepository.save(role);

        // Create and save a university user
        UniversityUser user = new UniversityUser();
        user.setFirstName("Alice");
        user.setLastName("Williams");
        user.setEmail("alice.williams@example.com");
        user.setUserRole_code(role); // Set the user's role
        user.setPassword("securePassword");
        universityUserRepository.save(user);

        // Perform an upload material request
        mockMvc.perform(post("/materials/upload-material")
                .param("materialName", "Uploaded Material")
                .param("description", "Description for uploaded material.")
                .param("uploadedByUserId", String.valueOf(user.getId())) // Use the ID of the created user
                .param("link", "http://example.com/materials/uploaded")
                .param("s3Address", "s3://bucket/path/uploaded")
                .param("isOnlineMaterial", "false")
                .contentType("application/x-www-form-urlencoded"))
                .andExpect(status().isOk()); // Expect a successful status response

        // Verify that the material was saved in the repository
        List<Material> materials = materialRepository.findAll();
        assertThat(materials).isNotEmpty();

        // Find the uploaded material by name
        Material uploadedMaterial = materials.stream()
                .filter(material -> "Uploaded Material".equals(material.getMaterialName()))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Uploaded material not found"));

        // Validate the uploaded material's details
        assertThat(uploadedMaterial.getDescription()).isEqualTo("Description for uploaded material.");
        assertThat(uploadedMaterial.getLink()).isEqualTo("http://example.com/materials/uploaded");
        assertThat(uploadedMaterial.getS3Address()).isEqualTo("s3://bucket/path/uploaded");
        assertThat(uploadedMaterial.getUniversityUser()).isEqualTo(user);
    }
}