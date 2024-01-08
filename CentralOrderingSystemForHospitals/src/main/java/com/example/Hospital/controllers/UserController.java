package com.example.Hospital.controllers;

import com.example.Hospital.models.*;
import com.example.Hospital.services.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping({"/users", "/api/register"})
public class UserController {

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


    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("username",new User());
        return "user_registration";
    }

    @PostMapping("/register")
    public String Register(@ModelAttribute User username,@RequestParam String confirmPassword){
        if(userServices.usernameTaken(username.getUsername())){
            return "redirect:/register?error=Username taken!";
        }
        if(userServices.emailTaken(username.getEmail())){
            return "redirect:/register?error=Email taken!";
        }
        if(!username.getPassword().equals(confirmPassword)){
            return "redirect:/register?error=Password mismatch!";
        }

        userServices.registerUser(username);


        return "redirect/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model){
        model.addAttribute("loginRequest",new User());
        return "user_login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User username, HttpSession session){
        if(!userServices.usernameTaken(username.getUsername())){
            return "redirect:/login?error=Wrong username or password";
        }
        if(userServices.authenticate(username.getUsername(),username.getPassword())){
            session.setAttribute("username",username.getId());
            session.setAttribute("userName",username.getUsername());
            return "redirect/";
        }
        return "redirect:/login?error=Wrong username or password";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsers(@RequestParam Map<String, String> params) {
        List<User> users = userServices.searchUsers(params);
        return ResponseEntity.ok(users);
    }
}


