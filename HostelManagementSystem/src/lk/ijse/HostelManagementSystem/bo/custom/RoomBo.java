package lk.ijse.HostelManagementSystem.bo.custom;

import lk.ijse.HostelManagementSystem.bo.SuperBo;
import lk.ijse.HostelManagementSystem.dto.RoomDto;
import lk.ijse.HostelManagementSystem.dto.StudentDto;
import lk.ijse.HostelManagementSystem.entity.Room;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RoomBo extends SuperBo {
    ArrayList<Room> getAllRoom() throws SQLException, ClassNotFoundException;

    boolean deleteRoom(String code) throws SQLException, ClassNotFoundException;

    boolean saveRoom(Room dto) throws SQLException, ClassNotFoundException;

    boolean updateRoom(Room dto) throws SQLException, ClassNotFoundException;

    boolean existsRoom(String code) throws SQLException, ClassNotFoundException;

    Room searchRoom(String code) throws SQLException, ClassNotFoundException;

    ArrayList<String> searchRoomCode() throws SQLException, ClassNotFoundException;
}
