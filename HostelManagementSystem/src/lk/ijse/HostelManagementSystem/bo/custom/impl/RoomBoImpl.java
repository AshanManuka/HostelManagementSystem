package lk.ijse.HostelManagementSystem.bo.custom.impl;

import lk.ijse.HostelManagementSystem.bo.custom.RoomBo;
import lk.ijse.HostelManagementSystem.dao.DaoFactory;
import lk.ijse.HostelManagementSystem.dao.custom.RoomDao;
import lk.ijse.HostelManagementSystem.dao.custom.impl.RoomDaoImpl;
import lk.ijse.HostelManagementSystem.dto.RoomDto;
import lk.ijse.HostelManagementSystem.entity.Room;

import java.sql.SQLException;
import java.util.ArrayList;

public class RoomBoImpl implements RoomBo {
    RoomDaoImpl roomDaoImpl = (RoomDaoImpl) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.ROOM);

    @Override
    public ArrayList<Room> getAllRoom() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean deleteRoom(String code) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean saveRoom(Room dto) throws SQLException, ClassNotFoundException {
        return roomDaoImpl.save(dto);
    }

    @Override
    public boolean updateRoom(Room dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean existsRoom(String code) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public RoomDto searchRoom(String code) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> searchRoomCode() throws SQLException, ClassNotFoundException {
        return null;
    }
}
