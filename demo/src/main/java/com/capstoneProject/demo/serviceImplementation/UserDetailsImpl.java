package com.capstoneProject.demo.serviceImplementation;

import com.capstoneProject.demo.entity.UniversityUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

    private UniversityUser user;

    private String userRoleCode;

    public UserDetailsImpl(UniversityUser user) {
        this.user = user;
        this.userRoleCode = user.getUserRole_code().getuserRoleCode();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "ROLE_" + userRoleCode);
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }
    public Long getId() {
        return user.getId();
    }

    public String getUserRoleCode() {
        return this.userRoleCode;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // Implement actual logic if needed
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // Implement actual logic if needed
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // Implement actual logic if needed
    }

    @Override
    public boolean isEnabled() {
        return true;  // Implement actual logic if needed
    }
}
