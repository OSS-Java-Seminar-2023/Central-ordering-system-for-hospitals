package entities;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@Data
@Entity
@Table(name = "SpecialistDoctor")
public class SpecialistDoctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "Specialization")
    private String specialization;

    @Column(name = "Address")
    private String address;
}
