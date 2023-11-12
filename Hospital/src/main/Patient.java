import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class Patient {
    private String id;
    private double insuranceNumber;
    private double bill;
}
