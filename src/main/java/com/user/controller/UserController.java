package com.user.controller;


import com.user.model.User;
import com.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")  // Enable cross-origin requests
public class UserController {

    @Autowired
    private UserService userService;

    // Register a new user
    @PostMapping("/register")
    public String registerUser(@RequestBody User newUser) {
        userService.registerUser(newUser);
        return "User registered successfully!";
    }

    // Login a user
    @PostMapping("/login")
    public boolean loginUser(@RequestBody User loginUser) {
        User user = userService.loginUser(loginUser.getUsername(), loginUser.getPassword());
        return user != null;  // Return true if login successful, false otherwise
    }
}
