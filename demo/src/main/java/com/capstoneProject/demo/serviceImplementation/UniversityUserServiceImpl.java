package com.capstoneProject.demo.serviceImplementation;

import com.capstoneProject.demo.convertors.UserConvertor;
import com.capstoneProject.demo.dtos.UniversityUserDTO;
import com.capstoneProject.demo.entity.UniversityUser;
import com.capstoneProject.demo.entity.UserRole;
import com.capstoneProject.demo.repository.UniversityUserRepository;
import com.capstoneProject.demo.repository.UserRoleRepository;
import com.capstoneProject.demo.service.UniversityUserService;
import com.capstoneProject.demo.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.capstoneProject.demo.convertors.UserConvertor.convertToDTO;

@Service
public class UniversityUserServiceImpl implements UniversityUserService {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UniversityUserRepository universityUserRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    public UniversityUserServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UniversityUserDTO> getAllUniversityUsers() {
        List<UniversityUser> users = universityUserRepository.findAll();
        return users.stream()
                .map(UserConvertor::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UniversityUserDTO getUniversityUserById(Long id) {
        UniversityUser user = universityUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return convertToDTO(user);
    }

    @Override
    public List<UniversityUserDTO> getUniversityUsersByRole(String role) {
        List<UniversityUser> users = universityUserRepository.findByUserRoleCode_UserRoleCode(role);
        return users.stream()
                .map(UserConvertor::convertToDTO)
                .collect(Collectors.toList());
    }

    public UniversityUserDTO createUniversityUser(UserDTO userDTO) {

        UserRole userRole = userRoleRepository.findByUserRoleCode(userDTO.getUserRoleCode());

        if (universityUserRepository.findOneByEmail(userDTO.getEmail()) != null
                || userRole == null) {
            return null;
        }
        UniversityUser universityUser = new UniversityUser();
        universityUser.setFirstName(userDTO.getFirstName());
        universityUser.setLastName(userDTO.getLastName());
        universityUser.setEmail(userDTO.getEmail());
        universityUser.setUserRole_code(userRole);
        universityUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));


        UniversityUser savedUser = universityUserRepository.save(universityUser);
        return convertToDTO(savedUser);
    }

    @Override
    public void deleteUniversityUser(Long id) {
        universityUserRepository.deleteById(id);
    }


}
