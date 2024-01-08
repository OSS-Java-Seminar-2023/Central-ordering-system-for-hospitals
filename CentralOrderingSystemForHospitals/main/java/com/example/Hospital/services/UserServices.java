package com.example.Hospital.services;

import com.example.Hospital.models.*;
import com.example.Hospital.repositories.UserRepository;
import com.example.Hospital.services.Spec.OrderSpecification;
import com.example.Hospital.services.Spec.UserSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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


    // this was in Username Service
    public void registerUser(User user){
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String hashedPassword =passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        userRepository.save(user);}


    public boolean usernameTaken(String username){
        Optional<User> userOptional=userRepository.findUsernameByUsername(username);
        return userOptional.isPresent();
    }


    public boolean emailTaken(String email){
        Optional<User> userOptional=userRepository.findUsernameByEmail(email);
        return userOptional.isPresent();
    }

    public boolean authenticate(String username,String password){
        BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
        Optional<User> optionalUsername =userRepository.findUsernameByUsername(username);

        if(optionalUsername.isPresent()){
            User user=optionalUsername.get();
            return passwordEncoder.matches(password, user.getPassword());

        }return false;
    }


    public List<User> searchUsers(Map<String, String> params) {
        Specification<User> spec = UserSpecification.buildSpecifications(params);
        return userRepository.findAll(spec);
    }

}
