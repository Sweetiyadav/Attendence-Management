package com.example.project12.service;


import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.project12.entity.User;
import com.example.project12.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepo;

    public CustomUserDetailsService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String rollNumber) throws UsernameNotFoundException {
        User user = userRepo.findByRollNumber(rollNumber);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with roll number: " + rollNumber);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getRollNumber(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole()))
        );
    }
}
