package com.example.Hospital.models;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private String id;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    @Column(name = "Date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "ResultID")
    private Result result;

    /*
    @ManyToOne
    @JoinColumn(name = "DoctorOfGeneralMedicineID")
    private User doctorOfGeneralMedicine;

    @ManyToOne
    @JoinColumn(name = "DoctorSpecialistID")
    private User doctorSpecialist;

    @ManyToOne
    @JoinColumn(name = "PatientID")
    private User patient;
    */
}
