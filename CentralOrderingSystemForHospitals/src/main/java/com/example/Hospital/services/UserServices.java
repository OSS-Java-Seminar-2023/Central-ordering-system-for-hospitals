package com.example.Hospital.services;

import com.example.Hospital.models.*;
import com.example.Hospital.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    UserRepository userRepository;
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String id){
        return userRepository.findById(id);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(String id){
        userRepository.deleteById(id);
    }
}
