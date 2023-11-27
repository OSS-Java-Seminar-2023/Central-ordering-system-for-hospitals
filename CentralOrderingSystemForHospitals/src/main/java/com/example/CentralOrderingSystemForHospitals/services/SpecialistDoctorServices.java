package services;

import model.SpecialistDoctor;
import java.util.List;

public interface SpecialistDoctorService {
    List<SpecialistDoctor> getAllSpecialistDoctors();
    SpecialistDoctor getSpecialistDoctorById(String id);
    SpecialistDoctor saveSpecialistDoctor(SpecialistDoctor specialistDoctor);
    void deleteSpecialistDoctor(String id);
}
package services;

        import entities.User;
        import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(String id);
    User saveUser(User user);
    void deleteUser(String id);
}
