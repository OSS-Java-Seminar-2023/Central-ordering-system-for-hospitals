package Entitys;

import lombok.*;

@AllArgsConstructor
@Data
public class User {
    private String ID;
    private String name;
    private String surname;
    private String contact;
    private String roleID;

}