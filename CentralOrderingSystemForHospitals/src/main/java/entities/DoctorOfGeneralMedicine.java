package entities;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@Entity
@Table(name = "DoctorOfGeneralMedicine")
public class DoctorOfGeneralMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "Address")
    private String address;
}
