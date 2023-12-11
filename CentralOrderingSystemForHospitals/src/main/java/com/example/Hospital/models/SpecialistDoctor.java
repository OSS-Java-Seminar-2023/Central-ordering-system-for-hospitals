package com.example.Hospital.models;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor

@Data
@Entity
@Table(name = "SpecialistDoctor")
public class SpecialistDoctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "Specialization")
    private String specialization;

    @Column(name = "Address")
    private String address;
}
