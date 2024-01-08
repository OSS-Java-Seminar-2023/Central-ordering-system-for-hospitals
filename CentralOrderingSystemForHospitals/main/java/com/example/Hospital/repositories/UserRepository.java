package com.example.Hospital.repositories;

import com.example.Hospital.models.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    public Optional<User> findUsernameByUsername(String username);
    public Optional<User> findUsernameByEmail(String email);

    public List<User> findAll(Specification<User> specification);
}

