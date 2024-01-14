package com.example.Hospital.dto;

import lombok.Data;

@Data
public class OrderDTO {
    private String id;
    private UserDTO user;
    private String date;
    private ResultDTO result;
}