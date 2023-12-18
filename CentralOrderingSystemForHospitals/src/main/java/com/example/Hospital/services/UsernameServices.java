package com.example.Hospital.services;


import com.example.Hospital.models.Username;
import com.example.Hospital.repositories.UsernameRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UsernameServices {


    UsernameRepository usernameRepository;

    public void registerUsername(Username username){
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String hashedPassword =passwordEncoder.encode(username.getPassword());
        username.setPassword(hashedPassword);

        usernameRepository.save(username);}


    public boolean usernameTaken(String username){
        Optional<Username> usernameOptional=usernameRepository.findUsernameByUsername(username);
        return usernameOptional.isPresent();
    }


    public boolean emailTaken(String email){
        Optional<Username> usernameOptional=usernameRepository.findUsernameByEmail(email);
        return usernameOptional.isPresent();
    }

    public boolean authenticate(String username,String password){
        BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
        Optional<Username> optionalUsername =usernameRepository.findUsernameByUsername(username);

        if(optionalUsername.isPresent()){
            Username user=optionalUsername.get();
            return passwordEncoder.matches(password, user.getPassword());

        }return false;
    }


    public List<Username> getAllUsernames(){
        return usernameRepository.findAll();
    }

    public Optional<Username> getUsernameById(String id){
        return usernameRepository.findById(id);
    }



    public void deleteUsername(String id){
        usernameRepository.deleteById(id);
    }
}
