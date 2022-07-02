package lk.ijse.HostelManagementSystem.bo.custom;

import lk.ijse.HostelManagementSystem.bo.SuperBo;
import lk.ijse.HostelManagementSystem.dto.RoomDto;
import lk.ijse.HostelManagementSystem.dto.StudentDto;
import lk.ijse.HostelManagementSystem.entity.Room;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RoomBo extends SuperBo {
    List<Room> getAllRoom() throws Exception;

    boolean deleteRoom(String code) throws Exception;

    boolean saveRoom(Room dto) throws Exception;

    boolean updateRoom(Room dto) throws Exception;

    String generateNewId() throws Exception;

    Room searchRoom(String code) throws Exception;

    Room searchType(String code) throws Exception;

    int searchRoomQty(String code,String name) throws Exception;

    int searchRoomQtyDel(String code,String name) throws Exception;

    ArrayList<String> searchRoomCode() throws Exception;
}
