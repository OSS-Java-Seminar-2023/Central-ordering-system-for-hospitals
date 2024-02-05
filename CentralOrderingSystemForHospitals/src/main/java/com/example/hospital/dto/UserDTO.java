package com.example.hospital.dto;

import com.example.hospital.models.UserRole;
import lombok.Data;

@Data
public class UserDTO {
    private String id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;
    private String contact;
    private UserRole role;
    private String address;
    private String specialisation;
    private String insuranceNumber;
    private String bill;
}
