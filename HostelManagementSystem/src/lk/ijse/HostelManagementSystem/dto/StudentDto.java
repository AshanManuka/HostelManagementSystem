package lk.ijse.HostelManagementSystem.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudentDto {
    private String stId;
    private String stName;
    private String stAddress;
    private int contact;
    private String dob;
    private String gender;
}
