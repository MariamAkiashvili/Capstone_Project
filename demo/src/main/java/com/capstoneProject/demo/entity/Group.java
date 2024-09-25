package com.capstoneProject.demo.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "university_group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "university_group_id")
    private long university_group_id;

    @Column(name = "university_group_name", nullable = false, length = 100)
    private String name;

    @Column(name = "university_group_code", unique = true, length = 50)
    private String code;

    public long getId(){
        return this.university_group_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
