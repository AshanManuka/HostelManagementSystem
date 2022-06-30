package lk.ijse.HostelManagementSystem.dao.custom.impl;

import lk.ijse.HostelManagementSystem.dao.custom.UserDao;
import lk.ijse.HostelManagementSystem.dto.UserDto;
import lk.ijse.HostelManagementSystem.entity.Room;
import lk.ijse.HostelManagementSystem.entity.User;
import lk.ijse.HostelManagementSystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private Session session;
    private Transaction transaction;
    int newCode;

    @Override
    public String exist() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {

        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();

        String hql = "FROM User ORDER BY userId DESC";
        List<User> userList = session.createQuery(hql).list();
        for (User user: userList) {
            String  lastId = user.getUserId();
            return lastId;
        }

        transaction.commit();
        session.close();
        return null;
    }

    @Override
    public ArrayList<User> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(User dto) throws SQLException, ClassNotFoundException {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        session.save(dto);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public ArrayList<String> searchId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public User search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(User dto) throws SQLException, ClassNotFoundException {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        session.update(dto);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        User user = session.load(User.class,s);
        session.delete(user);
        transaction.commit();
        session.close();
        return true;
    }
}
