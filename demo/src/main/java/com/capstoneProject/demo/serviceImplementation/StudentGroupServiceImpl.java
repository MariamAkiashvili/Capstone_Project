package com.capstoneProject.demo.serviceImplementation;

import com.capstoneProject.demo.convertors.StudentGroupConvertor;
import com.capstoneProject.demo.dtos.StudentGroupDTO;
import com.capstoneProject.demo.entity.Group;
import com.capstoneProject.demo.entity.StudentGroup;
import com.capstoneProject.demo.entity.UniversityUser;
import com.capstoneProject.demo.repository.GroupRepository;
import com.capstoneProject.demo.repository.StudentGroupRepository;
import com.capstoneProject.demo.repository.UniversityUserRepository;
import com.capstoneProject.demo.service.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentGroupServiceImpl implements StudentGroupService {

    @Autowired
    private StudentGroupRepository studentGroupRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UniversityUserRepository universityUserRepository;

    @Override
    public List<StudentGroupDTO> getAllStudentGroups() {
        List<StudentGroup> studentGroups = studentGroupRepository.findAll();
        return studentGroups.stream()
                .map(StudentGroupConvertor::convertTo)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentGroupDTO> getStudentGroupsByStudentId(long id) {
        List<StudentGroup> studentGroups = studentGroupRepository.findByStudent_UniversityUserId(id);
        return studentGroups.stream()
                .map(StudentGroupConvertor::convertTo)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentGroupDTO> getStudentGroupsByLecturerId(long id) {
        return List.of();
    }

    @Override
    public List<StudentGroupDTO> getStudentGroupsByGroupId(long id) {
        List<StudentGroup> studentGroups = studentGroupRepository.findByUniversityGroup_UniversityGroupId(id);

        return studentGroups.stream()
                .map(StudentGroupConvertor::convertTo)
                .collect(Collectors.toList());
    }

    @Override
    public StudentGroupDTO addStudentGroup(StudentGroupDTO studentGroupDTO) {
        StudentGroup studentGroup = new StudentGroup();
        studentGroup.setAddedDate(LocalDateTime.now());

        Optional<Group> group = groupRepository.findById(studentGroupDTO.getGroup().getUniversity_group_id());
        Optional<UniversityUser> universityUser = universityUserRepository.findById(studentGroupDTO.getStudent().getUniversityUserId());

        if (group.isPresent() && universityUser.isPresent()) {
            studentGroup.setGroup(group.get());
            studentGroup.setStudent(universityUser.get());
        } else {
            return null;
        }

        studentGroupRepository.save(studentGroup);


        studentGroupDTO.setAddedDate(LocalDateTime.now());
        return studentGroupDTO;
    }

    @Override
    public void deleteStudentGroupById(long id) {
        studentGroupRepository.deleteById(id);
    }
}
