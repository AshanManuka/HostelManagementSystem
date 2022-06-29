package lk.ijse.HostelManagementSystem.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    private String userId;
    private String userName;
    private String userAddress;
    private int userContact;
    private String uName;
    private String uPassword;

}
