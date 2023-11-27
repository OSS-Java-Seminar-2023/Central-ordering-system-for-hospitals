package services;

import model.DoctorOfGeneralMedicine;
import java.util.List;

public interface DoctorOfGeneralMedicineService {
    List<DoctorOfGeneralMedicine> getAllDoctors();
    DoctorOfGeneralMedicine getDoctorById(String id);
    DoctorOfGeneralMedicine saveDoctor(DoctorOfGeneralMedicine doctor);
    void deleteDoctor(String id);
}
