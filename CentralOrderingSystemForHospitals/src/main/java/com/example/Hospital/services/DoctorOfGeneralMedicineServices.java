package com.example.Hospital.services;

import com.example.Hospital.models.*;
import com.example.Hospital.repositories.DoctorOfGeneralMedicineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorOfGeneralMedicineServices {

    DoctorOfGeneralMedicineRepository doctorOfGeneralMedicineRepository;
    public List<DoctorOfGeneralMedicine> getAllDoctors(){
        return doctorOfGeneralMedicineRepository.findAll();
    }
    public Optional<DoctorOfGeneralMedicine> getDoctorById(String id){
        return doctorOfGeneralMedicineRepository.findById(id);
    }


    public DoctorOfGeneralMedicine saveDoctorOfGeneralMedicine(DoctorOfGeneralMedicine doctorOfGeneralMedicine) {
        return doctorOfGeneralMedicineRepository.save(doctorOfGeneralMedicine);
    }

    public void deleteDoctorOfGeneralMedicine(String id){
        doctorOfGeneralMedicineRepository.deleteById(id);

    }


}
