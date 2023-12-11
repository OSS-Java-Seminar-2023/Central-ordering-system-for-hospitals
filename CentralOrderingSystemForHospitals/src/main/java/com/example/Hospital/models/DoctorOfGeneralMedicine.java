package com.example.Hospital.models;

import lombok.*;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DoctorOfGeneralMedicine")
public class DoctorOfGeneralMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "Address")
    private String address;
}
