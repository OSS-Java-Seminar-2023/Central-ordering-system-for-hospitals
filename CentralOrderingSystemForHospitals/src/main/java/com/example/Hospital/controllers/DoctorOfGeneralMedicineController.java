package com.example.Hospital.controllers;

import com.example.Hospital.models.*;
import com.example.Hospital.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/general_doctors")
public class DoctorOfGeneralMedicineController {

    @Autowired
    private DoctorOfGeneralMedicineServices doctorOfGeneralMedicineServices;

    @GetMapping
    public List<DoctorOfGeneralMedicine> getAllDoctors() {
        return doctorOfGeneralMedicineServices.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Optional<DoctorOfGeneralMedicine> getDoctorById(@PathVariable String id) {
        return doctorOfGeneralMedicineServices.getDoctorById(id);
    }

    @PostMapping()
    public DoctorOfGeneralMedicine createDoctor(@RequestBody DoctorOfGeneralMedicine doctor) {
        return doctorOfGeneralMedicineServices.saveDoctorOfGeneralMedicine(doctor);
    }

    @PutMapping("/{id}")
    public DoctorOfGeneralMedicine updateDoctor(@PathVariable String id, @RequestBody DoctorOfGeneralMedicine doctor) {
        return doctorOfGeneralMedicineServices.saveDoctorOfGeneralMedicine(doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable String id) {
        doctorOfGeneralMedicineServices.deleteDoctorOfGeneralMedicine(id);
    }
}
