package com.capstoneProject.demo.serviceImplementation;

import com.capstoneProject.demo.convertors.CourseConvertor;
import com.capstoneProject.demo.dtos.CourseDTO;
import com.capstoneProject.demo.entity.Course;
import com.capstoneProject.demo.entity.Faculty;
import com.capstoneProject.demo.entity.UniversityUser;
import com.capstoneProject.demo.repository.CourseRepository;
import com.capstoneProject.demo.repository.FacultyRepository;
import com.capstoneProject.demo.repository.UniversityUserRepository;
import com.capstoneProject.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UniversityUserRepository universityUserRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public List<CourseDTO> getAllCourse() {
        List<Course> courses = courseRepository.findAll();

        return courses.stream().map(CourseConvertor::convertTo).collect(Collectors.toList());
    }

    @Override
    public CourseDTO addCurse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setCourseCode(courseDTO.getCourseCode());

        Optional<UniversityUser> optionalUser = universityUserRepository.findById(courseDTO.getLecturer().getUniversityUserId());


        Optional<Faculty> optionalFaculty = facultyRepository.findById(courseDTO.getFaculty().getCode());

        if (optionalUser.isPresent() && optionalFaculty.isPresent()) {
            UniversityUser universityUser = optionalUser.get();
            course.setLecturer(universityUser);

            Faculty faculty = optionalFaculty.get();
            course.setFaculty(faculty);

        } else {
            return null;
        }

        course.setCourseName(courseDTO.getCourseName());
        course.setMaxNumberOfStudents(courseDTO.getMaxNumberOfStudents());

        courseRepository.save(course);

        return courseDTO;
    }

    @Override
    public void deleteCourse(long id) {
        courseRepository.deleteById(id);

    }
}
