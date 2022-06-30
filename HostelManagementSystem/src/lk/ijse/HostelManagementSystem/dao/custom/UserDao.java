package lk.ijse.HostelManagementSystem.dao.custom;

import lk.ijse.HostelManagementSystem.dao.CrudDao;
import lk.ijse.HostelManagementSystem.entity.User;

import java.sql.SQLException;

public interface UserDao extends CrudDao<User,String> {

    String checkUserName(String code) throws SQLException, ClassNotFoundException;

    String checkPassword(String code) throws SQLException, ClassNotFoundException;
}
