package com.capstoneProject.demo.serviceImplementation;

import com.capstoneProject.demo.dtos.StudentProfileDTO;
import com.capstoneProject.demo.entity.Faculty;
import com.capstoneProject.demo.entity.StudentAdditionalInfo;
import com.capstoneProject.demo.entity.StudentGroup;
import com.capstoneProject.demo.entity.UniversityUser;
import com.capstoneProject.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentProfileServiceImpl {

    @Autowired
    private UniversityUserRepository universityUserRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private StudentAdditionalInfoRepository studentAdditionalInfoRepository;

    @Autowired
    private StudentGroupRepository studentGroupRepository;

    @Autowired
    private CourseRepository courseRepository;

    public StudentProfileDTO getUserProfile(Long userId) {
        StudentProfileDTO profile = new StudentProfileDTO();

        // Fetch the university user
        Optional<UniversityUser> userOptional = universityUserRepository.findById(userId);
        if (userOptional.isPresent()) {
            UniversityUser user = userOptional.get();

            profile.setUserId(user.getId());
            profile.setFirstName(user.getFirstName());
            profile.setLastName(user.getLastName());
            profile.setEmail(user.getEmail());

            // Fetch additional info if exists
            Optional<StudentAdditionalInfo> additionalInfoOptional = studentAdditionalInfoRepository.findByUniversityUser(user);
            if (additionalInfoOptional.isPresent()) {
                StudentAdditionalInfo additionalInfo = additionalInfoOptional.get();
                profile.setCurrentStudyYear(additionalInfo.getCurrentStudyYear());
                profile.setHasActiveStatus(additionalInfo.getHasActiveStatus());
                profile.setPhone(additionalInfo.getPhone());

                // Fetch faculty information directly using faculty_code from student additional info
                Faculty faculty = facultyRepository.findByCode(additionalInfo.getFaculty().getCode()).orElse(null);
                if (faculty != null) {
                    profile.setFacultyName(faculty.getName());
                }
            }

//            List<StudentGroup> studentGroups = studentGroupRepository.findByStudent_UniversityUserId(userId);
//            List<String> courses = new ArrayList<>();
//            for(StudentGroup studentGroup : studentGroups){
//                courses.add(courseRepository.findByCourseCode(studentGroup.ge))
//            }

        }

        return profile;
    }

    public StudentProfileDTO updatePhone(Long id, String phone) {
        StudentProfileDTO studentProfileDTO = new StudentProfileDTO();
        Optional<UniversityUser> userOptional = universityUserRepository.findById(id);
        if (userOptional.isPresent()) {
            UniversityUser user = userOptional.get();
            Optional<StudentAdditionalInfo> studentAdditionalInfo = studentAdditionalInfoRepository.findByUniversityUser(user);
            if(studentAdditionalInfo.isPresent()){
                StudentAdditionalInfo studentAdditionalInfo1 = studentAdditionalInfo.get();
                studentAdditionalInfo1.setPhone(phone);
                studentAdditionalInfoRepository.save(studentAdditionalInfo1);
            }else{
                return null;
            }
        }else {
            return null;
        }
        return studentProfileDTO;
    }
}
