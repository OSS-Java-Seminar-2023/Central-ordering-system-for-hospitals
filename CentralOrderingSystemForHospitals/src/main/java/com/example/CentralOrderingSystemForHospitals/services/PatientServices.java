package services;

import model.Patient;
import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();
    Patient getPatientById(String id);
    Patient savePatient(Patient patient);
    void deletePatient(String id);
}
