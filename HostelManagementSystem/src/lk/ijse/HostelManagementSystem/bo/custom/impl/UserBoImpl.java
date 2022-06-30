package lk.ijse.HostelManagementSystem.bo.custom.impl;

import lk.ijse.HostelManagementSystem.bo.custom.UserBo;
import lk.ijse.HostelManagementSystem.dao.DaoFactory;
import lk.ijse.HostelManagementSystem.dao.custom.StudentDao;
import lk.ijse.HostelManagementSystem.dao.custom.UserDao;
import lk.ijse.HostelManagementSystem.dao.custom.impl.RoomDaoImpl;
import lk.ijse.HostelManagementSystem.dao.custom.impl.UserDaoImpl;
import lk.ijse.HostelManagementSystem.dto.RoomDto;
import lk.ijse.HostelManagementSystem.dto.UserDto;
import lk.ijse.HostelManagementSystem.entity.Room;
import lk.ijse.HostelManagementSystem.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserBoImpl implements UserBo {
    UserDaoImpl userDaoImpl = (UserDaoImpl) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.USER);

    @Override
    public ArrayList<User> getAllUser() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean deleteUser(String code) throws SQLException, ClassNotFoundException {
        return userDaoImpl.delete(code);
    }

    @Override
    public boolean saveUser(User dto) throws SQLException, ClassNotFoundException {
        return userDaoImpl.save(dto);
    }

    @Override
    public boolean updateUser(User dto) throws SQLException, ClassNotFoundException {
        return userDaoImpl.update(dto);
    }

    @Override
    public String checkUserName(String code) throws SQLException, ClassNotFoundException {
        return userDaoImpl.checkUserName(code);
    }

    @Override
    public String checkPassword(String code) throws SQLException, ClassNotFoundException {
        return userDaoImpl.checkPassword(code);
    }


    @Override
    public String searchUser(String code) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewUserId() throws SQLException, ClassNotFoundException {
        return userDaoImpl.generateNewID();
    }

    @Override
    public ArrayList<String> searchUserCode() throws SQLException, ClassNotFoundException {
        return null;
    }
}
