import lombok.*;

@AllArgsConstructor
@Setter
@Getter
public class Order {
    private String orderID;
    private String doctorOfGeneralMedicineID;
    private String doctorSpecialistID;
    private String patientID;
    private String date;
    private String resultID;
}
