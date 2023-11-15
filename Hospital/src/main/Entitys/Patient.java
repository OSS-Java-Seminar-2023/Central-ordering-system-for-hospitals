package Entitys;

import lombok.*;

@AllArgsConstructor
@Data
public class Patient {
    private String id;
    private double insuranceNumber;
    private double bill;
}