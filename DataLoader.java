package com.example.project12.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.project12.entity.User;
import com.example.project12.repository.UserRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initUsers(UserRepository userRepo, BCryptPasswordEncoder encoder) {
        return args -> {
            // Admin user
            if (userRepo.findByRollNumber("ADMIN001") == null) {
                userRepo.save(new User(
                        "ADMIN001",
                        "Admin User",
                        encoder.encode("admin123"),
                        "admin@example.com",
                        "ROLE_ADMIN"
                ));
            }

            // Teacher user
            if (userRepo.findByRollNumber("TEACHER001") == null) {
                userRepo.save(new User(
                        "TEACHER001",
                        "Teacher User",
                        encoder.encode("teacher123"),
                        "teacher@example.com",
                        "ROLE_TEACHER"
                ));
            }

            // Student user
            if (userRepo.findByRollNumber("STUDENT001") == null) {
                userRepo.save(new User(
                        "STUDENT001",
                        "Student User",
                        encoder.encode("student123"),
                        "student@example.com",
                        "ROLE_STUDENT"
                ));
            }
        };
    }
}
