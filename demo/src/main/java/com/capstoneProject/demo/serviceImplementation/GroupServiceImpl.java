package com.capstoneProject.demo.serviceImplementation;

import com.capstoneProject.demo.convertors.GroupConvertor;
import com.capstoneProject.demo.dtos.GroupDTO;
import com.capstoneProject.demo.entity.Group;
import com.capstoneProject.demo.repository.GroupRepository;
import com.capstoneProject.demo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<GroupDTO> getAllGroups() {
        List<Group> groups = groupRepository.findAll();
        return groups.stream()
                .map(GroupConvertor::convertTo)
                .collect(Collectors.toList());
    }

    @Override
    public GroupDTO addGroup(GroupDTO groupDTO) {
        Group group = new Group();
        group.setCode(groupDTO.getCode());
        group.setName(groupDTO.getName());

        groupRepository.save(group);
        return groupDTO;
    }

    @Override
    public void deleteGroup(long id) {
        groupRepository.deleteById(id);
    }
}
