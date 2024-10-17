package com.capstoneProject.demo.dtos;

import java.time.LocalDateTime;

public class MaterialDTO {
    private long materialId;
    private String materialName;
    private String description;
    private LocalDateTime materialUploadDate;
    private LocalDateTime material_update_date;
    private UniversityUserDTO universityUser;
    private String link;
    private String s3Address;
    private boolean isOnlineMaterial;

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

    public UniversityUserDTO getUniversityUser() {
        return universityUser;
    }

    public void setUniversityUser(UniversityUserDTO universityUser) {
        this.universityUser = universityUser;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    public boolean getIsOnlineMaterial(){
        return this.isOnlineMaterial;
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
