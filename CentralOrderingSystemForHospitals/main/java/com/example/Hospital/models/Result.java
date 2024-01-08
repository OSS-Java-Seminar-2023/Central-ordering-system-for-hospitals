package com.example.Hospital.models;

import lombok.*;

import javax.persistence.*;
//import jakarta.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor

@AllArgsConstructor
@Entity
@Table(name = "Result")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "Diagnosis")
    private String diagnosis;

    @Column(name = "Advice")
    private String advice;
}
