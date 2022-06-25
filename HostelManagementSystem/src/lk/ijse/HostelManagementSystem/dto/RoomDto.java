package lk.ijse.HostelManagementSystem.dto;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RoomDto {
    private String roomId;
    private String roomType;
    private String keyMoney;
    private int qty;
}
