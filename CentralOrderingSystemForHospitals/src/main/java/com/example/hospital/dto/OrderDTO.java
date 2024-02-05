package com.example.hospital.dto;

import lombok.Data;

@Data
public class OrderDTO {
    private String id;
    private String date;
    private String resultId;
    private String doctorOfGeneralMedicineId;
    private String doctorSpecialistId;
    private String patientId;
}
