package lk.ijse.HostelManagementSystem.bo.custom.impl;

import lk.ijse.HostelManagementSystem.bo.custom.UserBo;
import lk.ijse.HostelManagementSystem.dao.DaoFactory;
import lk.ijse.HostelManagementSystem.dao.custom.StudentDao;
import lk.ijse.HostelManagementSystem.dao.custom.UserDao;
import lk.ijse.HostelManagementSystem.dto.RoomDto;
import lk.ijse.HostelManagementSystem.dto.UserDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserBoImpl implements UserBo {
    private final UserDao userDao = (UserDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.USER);

    @Override
    public ArrayList<UserDto> getAllUser() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean deleteUser(String code) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean saveUser(UserDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateUser(UserDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean existsUser(String code) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public RoomDto searchUser(String code) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewUserId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> searchUserCode() throws SQLException, ClassNotFoundException {
        return null;
    }
}
