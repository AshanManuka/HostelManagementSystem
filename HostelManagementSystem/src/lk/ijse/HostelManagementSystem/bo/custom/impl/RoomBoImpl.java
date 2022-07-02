package lk.ijse.HostelManagementSystem.bo.custom.impl;

import lk.ijse.HostelManagementSystem.bo.custom.RoomBo;
import lk.ijse.HostelManagementSystem.dao.DaoFactory;
import lk.ijse.HostelManagementSystem.dao.custom.RoomDao;
import lk.ijse.HostelManagementSystem.dao.custom.impl.RoomDaoImpl;
import lk.ijse.HostelManagementSystem.dto.RoomDto;
import lk.ijse.HostelManagementSystem.entity.Room;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomBoImpl implements RoomBo {
    RoomDaoImpl roomDaoImpl = (RoomDaoImpl) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.ROOM);

    @Override
    public List<Room> getAllRoom() throws Exception {
        return roomDaoImpl.getAll();
    }

    @Override
    public boolean deleteRoom(String code) throws Exception {
        return roomDaoImpl.delete(code);
    }

    @Override
    public boolean saveRoom(Room dto) throws Exception {
        return roomDaoImpl.save(dto);
    }

    @Override
    public boolean updateRoom(Room dto) throws Exception {
        return roomDaoImpl.update(dto);
    }

    @Override
    public String generateNewId() throws Exception {
        return roomDaoImpl.generateNewID();
    }

    @Override
    public Room searchRoom(String code) throws Exception {
        return roomDaoImpl.search(code);
    }

    @Override
    public Room searchType(String code) throws Exception {
        return roomDaoImpl.searchType(code);
    }

    @Override
    public int searchRoomQty(String code,String name) throws Exception {
        return roomDaoImpl.searchRoomQty(code,name);
    }

    @Override
    public int searchRoomQtyDel(String code, String name) throws Exception {
        return roomDaoImpl.searchRoomQtyDel(code,name);
    }

    @Override
    public ArrayList<String> searchRoomCode() throws Exception {
        return roomDaoImpl.searchId();
    }
}
