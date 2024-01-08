package com.example.Hospital.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor


@Data
@Entity
@Table(name = "User")
public class User {


    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-char")
    @Column(name = "ID")
    String id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Email")
    private String email;

    @Column(name = "Contact")
    private String contact;

    @Column(name = "Role")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name = "Address")
    private String address;    // mozda bude null ovisno o roli

    @Column(name = "Specialisation")
    private String specialisation;  // mozda bude null ovisno o roli

    @Column(name = "Insurance Number")
    private String insuranceNumber;  // mozda bude null ovisno o roli

    @Column(name = "Bill")
    private String bill;   // mozda bude null ovisno o roli

}
