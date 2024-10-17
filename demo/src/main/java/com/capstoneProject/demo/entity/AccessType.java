package com.capstoneProject.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "access_type")
public class AccessType {

    @Id
    @Column(name = "access_type_code")
    private String accessTypeCode;

    @Column(name = "access_type_name", nullable = false, length = 100)
    private String name;

    public String getCode() {
        return accessTypeCode;
    }

    public void setCode(String code) {
        this.accessTypeCode = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
