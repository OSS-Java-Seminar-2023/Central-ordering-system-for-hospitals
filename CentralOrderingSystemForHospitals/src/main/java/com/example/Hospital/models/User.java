package com.example.Hospital.models;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor


@Data
@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(name = "UserID", updatable = false, nullable = false)
    private String id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Contact")
    private String contact;

    @ManyToOne
    @JoinColumn(name = "RoleID")
    private DoctorOfGeneralMedicine doctorOfGeneralMedicine;

    @ManyToOne
    @JoinColumn(name = "RoleID")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "RoleID")
    private SpecialistDoctor specialistDoctor;

}
