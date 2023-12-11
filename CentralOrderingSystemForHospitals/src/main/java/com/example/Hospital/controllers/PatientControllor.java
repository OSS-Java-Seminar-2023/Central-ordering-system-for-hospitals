package com.example.Hospital.controllers;

import com.example.Hospital.models.*;
import com.example.Hospital.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientControllor {

    @Autowired
    private PatientServices patientServices;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientServices.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable String id) {
        return patientServices.getPatientById(id);
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientServices.savePatient(patient);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable String id, @RequestBody Patient patient) {

        return patientServices.savePatient(patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable String id) {
        patientServices.deletePatient(id);
    }
}
