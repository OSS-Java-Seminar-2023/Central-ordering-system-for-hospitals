package entities;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@Data
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "UserID")
    private String id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Contact")
    private String contact;

    @ManyToOne
    @JoinColumn(name = "RoleID")
    private DoctorOfGeneralMedicine doctorOfGeneralMedicine;

    @ManyToOne
    @JoinColumn(name = "RoleID")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "RoleID")
    private SpecialistDoctor specialistDoctor;
}
