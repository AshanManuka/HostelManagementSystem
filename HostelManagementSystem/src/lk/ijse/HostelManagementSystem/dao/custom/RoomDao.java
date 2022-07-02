package lk.ijse.HostelManagementSystem.dao.custom;

import lk.ijse.HostelManagementSystem.dao.CrudDao;
import lk.ijse.HostelManagementSystem.dto.RoomDto;
import lk.ijse.HostelManagementSystem.entity.Room;

import java.sql.SQLException;

public interface RoomDao extends CrudDao<Room,String> {
    public boolean updateQty(int qty) throws Exception;

    int searchRoomQty(String code) throws Exception;
}
