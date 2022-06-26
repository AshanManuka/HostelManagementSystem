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
public class Reservation {
    @Id
    private String reservationId;
    private String date;
    private String studentId;
    private String roomId;
    private String status;
}
