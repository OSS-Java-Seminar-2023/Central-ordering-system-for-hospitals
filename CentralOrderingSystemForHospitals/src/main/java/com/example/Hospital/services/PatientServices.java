package com.example.Hospital.services;

import com.example.Hospital.models.*;
import com.example.Hospital.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServices {

    PatientServices patientServices;
    public List<Patient> getAllPatients(){
        return patientServices.getAllPatients();
    }
    public Patient getPatientById(String id){
        return patientServices.getPatientById(id);
    }
    public Patient savePatient(Patient patient){
        return patientServices.savePatient(patient);
    }
    public void deletePatient(String id){
        patientServices.deletePatient(id);
    }
}
