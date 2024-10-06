package com.capstoneProject.demo.service;

import com.capstoneProject.demo.dtos.GroupDTO;

import java.util.List;

public interface GroupService {
    List<GroupDTO> getAllGroups();

    GroupDTO addGroup(GroupDTO groupDTO);

    void deleteGroup(long id);
}
