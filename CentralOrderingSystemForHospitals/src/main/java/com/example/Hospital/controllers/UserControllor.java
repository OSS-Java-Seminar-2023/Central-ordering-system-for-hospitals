package com.example.Hospital.controllers;

import com.example.Hospital.models.*;
import com.example.Hospital.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/users", "/api/register"})
public class UserControllor {

    @Autowired
    private UserServices userServices;

    @GetMapping
    public List<User> getAllUsers() {
        return userServices.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable String id) {
        return userServices.getUserById(id);
    }


    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userServices.saveUser(user);
        return ResponseEntity.ok("User registered successfully!");
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        return userServices.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userServices.deleteUser(id);
    }
}
