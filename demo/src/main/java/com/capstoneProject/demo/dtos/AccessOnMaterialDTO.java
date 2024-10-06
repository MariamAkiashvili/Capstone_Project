package com.capstoneProject.demo.dtos;

public class AccessOnMaterialDTO {
    private long accessOnMaterialId;
    private MaterialDTO material;
    private GroupDTO group;
    private AccessTypeDTO accessType;

    public long getAccessOnMaterialId() {
        return accessOnMaterialId;
    }

    public void setAccessOnMaterialId(long accessOnMaterialId) {
        this.accessOnMaterialId = accessOnMaterialId;
    }

    public MaterialDTO getMaterial() {
        return material;
    }

    public void setMaterial(MaterialDTO material) {
        this.material = material;
    }

    public GroupDTO getGroup() {
        return group;
    }

    public void setGroup(GroupDTO group) {
        this.group = group;
    }

    public AccessTypeDTO getAccessType() {
        return accessType;
    }

    public void setAccessType(AccessTypeDTO accessType) {
        this.accessType = accessType;
    }
}
