package com.example.Hospital.controllers;

import com.example.Hospital.models.*;
import com.example.Hospital.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specialistdoctors")
public class SpecialistDoctorControllor {

    @Autowired
    private SpecialistDoctorServices specialistDoctorServices;

    @GetMapping
    public List<SpecialistDoctor> getAllSpecialistDoctors() {
        return specialistDoctorServices.getAllSpecialistDoctors();
    }

    @GetMapping("/{id}")
    public SpecialistDoctor getSpecialistDoctorById(@PathVariable String id) {
        return specialistDoctorServices.getSpecialistDoctorById(id);
    }

    @PostMapping
    public SpecialistDoctor createSpecialistDoctor(@RequestBody SpecialistDoctor specialistDoctor) {
        return specialistDoctorServices.saveSpecialistDoctor(specialistDoctor);
    }

    @PutMapping("/{id}")
    public SpecialistDoctor updateSpecialistDoctor(@PathVariable String id, @RequestBody SpecialistDoctor specialistDoctor) {
        return specialistDoctorServices.saveSpecialistDoctor(specialistDoctor);
    }

    @DeleteMapping("/{id}")
    public void deleteSpecialistDoctor(@PathVariable String id) {
        specialistDoctorServices.deleteSpecialistDoctor(id);
    }
}
