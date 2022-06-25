package lk.ijse.HostelManagementSystem.dao.custom.impl;

import lk.ijse.HostelManagementSystem.dao.custom.RoomDao;
import lk.ijse.HostelManagementSystem.dto.RoomDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class RoomDaoImpl implements RoomDao {

    @Override
    public String exist() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<RoomDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(RoomDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public RoomDto search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(RoomDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }
}
