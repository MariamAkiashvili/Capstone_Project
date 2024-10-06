package com.capstoneProject.demo.dtos;

public class GroupDTO {
    private long university_group_id;
    private String name;
    private String code;

    public long getUniversity_group_id() {
        return university_group_id;
    }

    public void setUniversity_group_id(long university_group_id) {
        this.university_group_id = university_group_id;
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
