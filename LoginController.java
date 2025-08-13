// package com.example.project12.controller;

// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;

// @Controller
// public class LoginController {

//     @GetMapping("/login")
//     public String loginPage() {
//         return "login";
//     }

//     @GetMapping("/home")
//     public String homePage() {
//         return "home";
//     }
// }



package com.example.project12.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Thymeleaf template name: login.html
    }

    @GetMapping("/home")
    public String homePage() {
        return "home"; // Thymeleaf template name: home.html
    }
}
