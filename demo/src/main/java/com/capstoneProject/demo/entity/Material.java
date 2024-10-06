package com.capstoneProject.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Table(name = "material")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_id")
    private long materialId;

    @Column(name = "material_name", nullable = false, length = 200)
    private String materialName;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "material_upload_date", columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime materialUploadDate;

    @Column(name = "material_update_date", columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime material_update_date;

    @ManyToOne
    @JoinColumn(name = "uploaded_by_user_id", referencedColumnName = "university_user_id", nullable = false)
    private UniversityUser uploadedByUserId;


    @Column(name = "link", length = 1000)
    private String link;

    @Column(name = "is_online_material", columnDefinition = "boolean default false")
    private boolean isOnlineMaterial;

    @Column(name = "s3_address")
    private String s3Address;


    public long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(long materialId) {
        this.materialId = materialId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getMaterialUploadDate() {
        return materialUploadDate;
    }

    public void setMaterialUploadDate(LocalDateTime materialUploadDate) {
        this.materialUploadDate = materialUploadDate;
    }

    public LocalDateTime getMaterial_update_date() {
        return material_update_date;
    }

    public void setMaterial_update_date(LocalDateTime material_update_date) {
        this.material_update_date = material_update_date;
    }

    public UniversityUser getUniversityUser() {
        return uploadedByUserId;
    }

    public void setUniversityUser(UniversityUser universityUser) {
        this.uploadedByUserId = universityUser;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean getIsOnlineMaterial(){
        return isOnlineMaterial;
    }

    public void setIsOnlineMaterial(boolean isOnlineMaterial){
        this.isOnlineMaterial = isOnlineMaterial;
    }

    public String getS3Address() {
        return s3Address;
    }

    public void setS3Address(String s3Address) {
        this.s3Address = s3Address;
    }
}
