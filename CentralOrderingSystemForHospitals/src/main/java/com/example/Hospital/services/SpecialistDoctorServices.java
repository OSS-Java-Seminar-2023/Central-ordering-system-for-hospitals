package com.example.Hospital.services;

import com.example.Hospital.models.*;
import com.example.Hospital.repositories.SpecialistDoctorRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SpecialistDoctorServices {

    SpecialistDoctorRepository specialistDoctorRepository;
    public List<SpecialistDoctor> getAllSpecialistDoctors(){
        return specialistDoctorRepository.findAll();
    }
    public SpecialistDoctor getSpecialistDoctorById(String id){
        return specialistDoctorRepository.getReferenceById(id);
    }


    public SpecialistDoctor saveSpecialistDoctor(SpecialistDoctor specialistDoctor){
        return specialistDoctorRepository.save(specialistDoctor);
    }
    public void deleteSpecialistDoctor(String id){
        specialistDoctorRepository.deleteById(id);
    }
}
