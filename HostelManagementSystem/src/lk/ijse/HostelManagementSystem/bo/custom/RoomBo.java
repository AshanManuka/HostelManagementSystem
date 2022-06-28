package lk.ijse.HostelManagementSystem.bo.custom;

import lk.ijse.HostelManagementSystem.bo.SuperBo;
import lk.ijse.HostelManagementSystem.dto.RoomDto;
import lk.ijse.HostelManagementSystem.dto.StudentDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RoomBo extends SuperBo {
    ArrayList<RoomDto> getAllRoom() throws SQLException, ClassNotFoundException;

    boolean deleteRoom(String code) throws SQLException, ClassNotFoundException;

    boolean saveRoom(RoomDto dto) throws SQLException, ClassNotFoundException;

    boolean updateRoom(RoomDto dto) throws SQLException, ClassNotFoundException;

    boolean existsRoom(String code) throws SQLException, ClassNotFoundException;

    RoomDto searchRoom(String code) throws SQLException, ClassNotFoundException;

    ArrayList<String> searchRoomCode() throws SQLException, ClassNotFoundException;
}
