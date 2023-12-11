package com.example.Hospital.repositories;

import com.example.Hospital.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorOfGeneralMedicineRepository extends JpaRepository<DoctorOfGeneralMedicine, String> {
}

