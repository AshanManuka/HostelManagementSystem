package lk.ijse.HostelManagementSystem.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReservationDto {
    private String reservationId;
    private String date;
    private String studentId;
    private String roomId;
    private String status;

}
