package lk.ijse.HostelManagementSystem.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CrudDao<T,ID> extends SuperDao {

    String generateNewID() throws SQLException, ClassNotFoundException;

    List<T> getAll() throws SQLException, ClassNotFoundException;

    boolean save(T dto) throws SQLException, ClassNotFoundException;

    ArrayList<String> searchId()throws SQLException,ClassNotFoundException;

    T search(ID id)throws SQLException,ClassNotFoundException;

    boolean update(T dto) throws SQLException, ClassNotFoundException;

    boolean delete(ID id) throws SQLException, ClassNotFoundException;

}
