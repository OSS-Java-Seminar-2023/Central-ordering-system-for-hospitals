package com.example.Hospital.repositories;

import com.example.Hospital.models.User;
import com.example.Hospital.models.Username;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UsernameRepository extends JpaRepository<Username, String>{

    public Optional<Username> findUsernameByUsername(String username);
    public Optional<Username> findUsernameByEmail(String email);

}
