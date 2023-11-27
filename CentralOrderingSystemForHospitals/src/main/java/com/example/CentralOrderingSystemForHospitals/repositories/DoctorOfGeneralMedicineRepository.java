package repositories;

import models.DoctorOfGeneralMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorOfGeneralMedicineRepository extends JpaRepository<DoctorOfGeneralMedicine, String> {
}

