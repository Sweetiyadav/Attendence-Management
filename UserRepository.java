package com.example.project12.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project12.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByRollNumber(String rollNumber);
}


