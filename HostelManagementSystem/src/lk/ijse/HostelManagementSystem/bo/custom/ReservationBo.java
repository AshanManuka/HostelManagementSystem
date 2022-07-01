package lk.ijse.HostelManagementSystem.bo.custom;

import lk.ijse.HostelManagementSystem.bo.SuperBo;
import lk.ijse.HostelManagementSystem.dto.StudentDto;
import lk.ijse.HostelManagementSystem.entity.Reservation;
import lk.ijse.HostelManagementSystem.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ReservationBo extends SuperBo {
    List<Reservation> getAllReservation() throws SQLException, ClassNotFoundException;

    boolean deleteReservation(String code) throws SQLException, ClassNotFoundException;

    boolean saveReservation(Reservation dto) throws SQLException, ClassNotFoundException;

    String generateNewId() throws SQLException, ClassNotFoundException;

}
