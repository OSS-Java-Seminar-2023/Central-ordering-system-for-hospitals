package com.example.Hospital.dto;

import lombok.Data;
import com.example.Hospital.models.UserRole;

@Data
public class UserDTO {
    private String id;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String contact;
    private UserRole role;
    private String address;
    private String specialisation;
    private String insuranceNumber;
    private String bill;
}