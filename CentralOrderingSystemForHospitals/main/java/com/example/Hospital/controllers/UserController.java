package com.example.Hospital.controllers;

import com.example.Hospital.models.User;
import com.example.Hospital.services.UserServices;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping
    public String getAllUsers(Model model) {
        List<User> users = userServices.getAllUsers();
        model.addAttribute("users", users);
        return "user/list";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable String id, Model model) {
        Optional<User> user = userServices.getUserById(id);
        user.ifPresent(u -> model.addAttribute("user", u));
        return "user/details";
    }

    @PostMapping
    public String registerUser(@ModelAttribute("user") User user) {
        userServices.saveUser(user);
        return "redirect:/users";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable String id, @ModelAttribute("user") User user) {
        Optional<User> existingUserOptional = userServices.getUserById(id);

        if (existingUserOptional.isPresent()) {
            userServices.saveUser(user);
            return "redirect:/users";
        }
        else{
            return "redirect:/users?error=User not found";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        userServices.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "user_registration";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, @RequestParam String confirmPassword) {
        if (userServices.usernameTaken(user.getUsername())) {
            return "redirect:/register?error=Username taken!";
        }
        if (userServices.emailTaken(user.getEmail())) {
            return "redirect:/register?error=Email taken!";
        }
        if (!user.getPassword().equals(confirmPassword)) {
            return "redirect:/register?error=Password mismatch!";
        }

        userServices.registerUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginRequest", new User());
        return "user_login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, HttpSession session) {
        if (!userServices.usernameTaken(user.getUsername())) {
            return "redirect:/login?error=Wrong username or password";
        }
        if (userServices.authenticate(user.getUsername(), user.getPassword())) {
            session.setAttribute("username", user.getId());
            session.setAttribute("userName", user.getUsername());
            return "redirect:/";
        }
        return "redirect:/login?error=Wrong username or password";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchUsers(@RequestParam Map<String, String> params, Model model) {
        List<User> users = userServices.searchUsers(params);
        model.addAttribute("users", users);
        return "user/list";
    }
}
