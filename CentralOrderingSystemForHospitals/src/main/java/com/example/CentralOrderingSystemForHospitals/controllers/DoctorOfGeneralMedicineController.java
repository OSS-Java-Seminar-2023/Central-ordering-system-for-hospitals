import model.DoctorOfGeneralMedicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorOfGeneralMedicineController {

    @Autowired
    private DoctorOfGeneralMedicineService doctorService;

    @GetMapping
    public List<DoctorOfGeneralMedicine> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public DoctorOfGeneralMedicine getDoctorById(@PathVariable String id) {
        return doctorService.getDoctorById(id);
    }

    @PostMapping
    public DoctorOfGeneralMedicine createDoctor(@RequestBody DoctorOfGeneralMedicine doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @PutMapping("/{id}")
    public DoctorOfGeneralMedicine updateDoctor(@PathVariable String id, @RequestBody DoctorOfGeneralMedicine doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable String id) {
        doctorService.deleteDoctor(id);
    }
}
