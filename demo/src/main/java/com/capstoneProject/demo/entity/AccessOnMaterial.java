package com.capstoneProject.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "access_on_material")
public class AccessOnMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "access_on_material_id")
    private long accessOnMaterialId;

    @ManyToOne
    @JoinColumn(name = "material_id", referencedColumnName = "material_id", nullable = false)
    private Material material;

    @ManyToOne
    @JoinColumn(name = "university_group_id", referencedColumnName = "university_group_id", nullable = false)
    private Group group;

    @ManyToOne
    @JoinColumn(name = "access_type_code", referencedColumnName = "access_type_code", nullable = false)
    private AccessType accessType;

}
