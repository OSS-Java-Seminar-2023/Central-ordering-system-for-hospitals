package entities;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@Data
@Entity
@Table(name = "Patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "InsuranceNumber")
    private double insuranceNumber;

    @Column(name = "Bill")
    private double bill;
}
