package com.capstoneProject.demo.convertors;

import com.capstoneProject.demo.dtos.GroupDTO;
import com.capstoneProject.demo.entity.Group;

public class GroupConvertor {
    public static GroupDTO convertTo(Group group){
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setUniversity_group_id(group.getId());
        groupDTO.setName(group.getName());
        groupDTO.setCode(group.getCode());

        return groupDTO;
    }
}
