package com.example.Hospital.controllers;


import com.example.Hospital.models.Username;
import com.example.Hospital.services.UsernameServices;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping({"/usernames"})
public class UsernameController {
    @Autowired
    UsernameServices usernameServices;

    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("username",new Username());
        return "user_registration";
    }

    @PostMapping("/register")
    public String Register(@ModelAttribute Username username,@RequestParam String confirmPassword){
        if(usernameServices.usernameTaken(username.getUsername())){
            return "redirect:/register?error=Username taken!";
        }
        if(usernameServices.emailTaken(username.getEmail())){
            return "redirect:/register?error=Email taken!";
        }
        if(!username.getPassword().equals(confirmPassword)){
            return "redirect:/register?error=Password mismatch!";
        }

        usernameServices.registerUsername(username);


        return "redirect/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model){
        model.addAttribute("loginRequest",new Username());
        return "user_login";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute Username username, HttpSession session){
        if(!usernameServices.usernameTaken(username.getUsername())){
            return "redirect:/login?error=Wrong username or password";
        }
        if(usernameServices.authenticate(username.getUsername(),username.getPassword())){
            session.setAttribute("username",username.getId());
            session.setAttribute("userName",username.getUsername());
            return "redirect/";
        }
        return "redirect:/login?error=Wrong username or password";
    }



    @GetMapping
    public List<Username> getAllUsernames() {
        return usernameServices.getAllUsernames();
    }

    @GetMapping("/{id}")
    public Optional<Username> getUserById(@PathVariable String id) {
        return usernameServices.getUsernameById(id);
    }




    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        usernameServices.deleteUsername(id);
    }



}
