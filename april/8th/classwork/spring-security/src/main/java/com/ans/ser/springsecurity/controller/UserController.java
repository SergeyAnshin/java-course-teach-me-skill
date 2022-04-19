package com.ans.ser.springsecurity.controller;

import com.ans.ser.springsecurity.entity.User;
import com.ans.ser.springsecurity.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginTemplate() {
        return "login";
    }

    @GetMapping("/reg")
    public String getRegistrationTemplate() {
        return "registration";
    }

    @PostMapping("/reg")
    public String signup(User user) {
        userService.save(user);
        return "registration";
    }
}
