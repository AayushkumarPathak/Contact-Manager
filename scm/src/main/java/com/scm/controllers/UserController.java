package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    // user dashboard route
    @RequestMapping("/dashboard")
    public String userDashboard(){
        return "user/dashboard";
    }

    // user profile route
    @RequestMapping("/profile")
    public String userProfile(){
        return "user/profile";
    }
}
