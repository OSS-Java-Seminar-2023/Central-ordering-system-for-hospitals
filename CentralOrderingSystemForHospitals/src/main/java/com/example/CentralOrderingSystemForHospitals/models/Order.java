package entities;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@Entity
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OrderID")
    private String orderID;

    @ManyToOne
    @JoinColumn(name = "DoctorOfGeneralMedicineID")
    private User doctorOfGeneralMedicine;

    @ManyToOne
    @JoinColumn(name = "DoctorSpecialistID")
    private User doctorSpecialist;

    @ManyToOne
    @JoinColumn(name = "PatientID")
    private User patient;

    @Column(name = "Date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "ResultID")
    private Result result;
}
