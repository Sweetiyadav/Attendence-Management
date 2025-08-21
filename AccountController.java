
package com.example.project12.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.project12.entity.User;
import com.example.project12.repository.UserRepository;

@Controller
public class AccountController {

    private final UserRepository userRepository;

    public AccountController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/account")
    public String accountPage(Authentication authentication, Model model) {
        String rollNumber = authentication.getName(); // login kiya hua user ka roll
        User user = userRepository.findByRollNumber(rollNumber); // DB se user details
        model.addAttribute("user", user);
        return "account"; // account.html
    }
}
