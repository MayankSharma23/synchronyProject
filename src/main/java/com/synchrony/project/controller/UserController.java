package com.synchrony.project.controller;

import com.synchrony.project.model.User;
import com.synchrony.project.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private  UserRepository userRepository;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }


    @GetMapping("/view-user/{username}/{password}")
    public User viewUser(@PathVariable String username, @PathVariable String password) {
        User user = userRepository.findByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            throw new SecurityException("Invalid credentials");
        }
        return user;
    }
}
