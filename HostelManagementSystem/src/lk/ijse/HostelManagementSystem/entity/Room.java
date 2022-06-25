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
public class Room {
    @Id
    private String roomId;
    private String roomType;
    private String keyMoney;
    private int qty;
}
