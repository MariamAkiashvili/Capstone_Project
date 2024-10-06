package com.capstoneProject.demo.serviceImplementation;

import com.capstoneProject.demo.entity.UniversityUser;
import com.capstoneProject.demo.repository.UniversityUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UniversityUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UniversityUser user = userRepository.findOneByEmail(email);  // Fetch user by email from the repository
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return new UserDetailsImpl(user);  // Return an instance of UserDetailsImpl
    }
}
