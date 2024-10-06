package com.capstoneProject.demo.serviceImplementation;

import com.capstoneProject.demo.entity.UniversityUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsImpl implements UserDetails {

    private UniversityUser user;

    public UserDetailsImpl(UniversityUser user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // You can return authorities based on user roles, for now, returning null
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
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
