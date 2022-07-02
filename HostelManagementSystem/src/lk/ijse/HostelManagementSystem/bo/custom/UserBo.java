package lk.ijse.HostelManagementSystem.bo.custom;

import lk.ijse.HostelManagementSystem.bo.SuperBo;
import lk.ijse.HostelManagementSystem.dto.RoomDto;
import lk.ijse.HostelManagementSystem.dto.UserDto;
import lk.ijse.HostelManagementSystem.entity.Room;
import lk.ijse.HostelManagementSystem.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserBo extends SuperBo {
    ArrayList<User> getAllUser() throws Exception;

    boolean deleteUser(String code) throws Exception;

    boolean saveUser(User dto) throws Exception;

    boolean updateUser(User dto) throws Exception;

    String checkUserName(String code) throws Exception;

    String checkPassword(String code) throws Exception;

    String searchUser(String code) throws Exception;

    User search(String code) throws Exception;

    String generateNewUserId() throws Exception;

    ArrayList<String> searchUserCode() throws Exception;
}
