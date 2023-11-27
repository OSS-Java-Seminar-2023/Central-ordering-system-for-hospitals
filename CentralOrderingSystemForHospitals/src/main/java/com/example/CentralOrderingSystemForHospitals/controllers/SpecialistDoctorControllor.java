import model.SpecialistDoctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specialistdoctors")
public class SpecialistDoctorController {

    @Autowired
    private SpecialistDoctorService specialistDoctorService;

    @GetMapping
    public List<SpecialistDoctor> getAllSpecialistDoctors() {
        return specialistDoctorService.getAllSpecialistDoctors();
    }

    @GetMapping("/{id}")
    public SpecialistDoctor getSpecialistDoctorById(@PathVariable String id) {
        return specialistDoctorService.getSpecialistDoctorById(id);
    }

    @PostMapping
    public SpecialistDoctor createSpecialistDoctor(@RequestBody SpecialistDoctor specialistDoctor) {
        return specialistDoctorService.saveSpecialistDoctor(specialistDoctor);
    }

    @PutMapping("/{id}")
    public SpecialistDoctor updateSpecialistDoctor(@PathVariable String id, @RequestBody SpecialistDoctor specialistDoctor) {
        return specialistDoctorService.saveSpecialistDoctor(specialistDoctor);
    }

    @DeleteMapping("/{id}")
    public void deleteSpecialistDoctor(@PathVariable String id) {
        specialistDoctorService.deleteSpecialistDoctor(id);
    }
}
