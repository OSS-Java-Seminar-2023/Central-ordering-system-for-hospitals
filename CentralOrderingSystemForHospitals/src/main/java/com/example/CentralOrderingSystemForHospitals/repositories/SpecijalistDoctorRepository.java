package repositories;

import models.SpecialistDoctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialistDoctorRepository extends JpaRepository<SpecialistDoctor, String> {
}

