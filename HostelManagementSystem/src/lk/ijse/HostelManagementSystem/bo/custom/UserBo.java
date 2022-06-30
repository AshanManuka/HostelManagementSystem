package lk.ijse.HostelManagementSystem.bo.custom;

import lk.ijse.HostelManagementSystem.bo.SuperBo;
import lk.ijse.HostelManagementSystem.dto.RoomDto;
import lk.ijse.HostelManagementSystem.dto.UserDto;
import lk.ijse.HostelManagementSystem.entity.Room;
import lk.ijse.HostelManagementSystem.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserBo extends SuperBo {
    ArrayList<User> getAllUser() throws SQLException, ClassNotFoundException;

    boolean deleteUser(String code) throws SQLException, ClassNotFoundException;

    boolean saveUser(User dto) throws SQLException, ClassNotFoundException;

    boolean updateUser(User dto) throws SQLException, ClassNotFoundException;

    String checkUserName(String code) throws SQLException, ClassNotFoundException;

    String checkPassword(String code) throws SQLException, ClassNotFoundException;

    String searchUser(String code) throws SQLException, ClassNotFoundException;

    User search(String code) throws SQLException, ClassNotFoundException;

    String generateNewUserId() throws SQLException, ClassNotFoundException;

    ArrayList<String> searchUserCode() throws SQLException, ClassNotFoundException;
}
