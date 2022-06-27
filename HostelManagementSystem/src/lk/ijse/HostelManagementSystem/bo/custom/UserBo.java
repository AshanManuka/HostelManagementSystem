package lk.ijse.HostelManagementSystem.bo.custom;

import lk.ijse.HostelManagementSystem.bo.SuperBo;
import lk.ijse.HostelManagementSystem.dto.RoomDto;
import lk.ijse.HostelManagementSystem.dto.UserDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserBo extends SuperBo {
    ArrayList<UserDto> getAllUser() throws SQLException, ClassNotFoundException;

    boolean deleteUser(String code) throws SQLException, ClassNotFoundException;

    boolean saveUser(UserDto dto) throws SQLException, ClassNotFoundException;

    boolean updateUser(UserDto dto) throws SQLException, ClassNotFoundException;

    boolean existsUser(String code) throws SQLException, ClassNotFoundException;

    RoomDto searchUser(String code) throws SQLException, ClassNotFoundException;

    String generateNewUserId() throws SQLException, ClassNotFoundException;

    ArrayList<String> searchUserCode() throws SQLException, ClassNotFoundException;
}
