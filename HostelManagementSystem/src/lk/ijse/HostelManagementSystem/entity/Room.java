package lk.ijse.HostelManagementSystem.entity;

import lk.ijse.HostelManagementSystem.dto.ReservationDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;
import java.util.ArrayList;
import java.util.List;

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
    //@ManyToMany
    //private List<ReservationDto> reservation;
}
