package entities;

import lombok.*;

import javax.persistence.*;


@Data
@AllArgsConstructor
@Entity
@Table(name = "DoctorOfGeneralMedicine")
public class DoctorOfGeneralMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "Address")
    private String address;
}
