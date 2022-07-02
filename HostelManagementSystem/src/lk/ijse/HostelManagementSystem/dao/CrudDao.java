package lk.ijse.HostelManagementSystem.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CrudDao<T,ID> extends SuperDao {

    String generateNewID() throws Exception;

    List<T> getAll() throws Exception;

    boolean save(T dto) throws Exception;

    ArrayList<String> searchId()throws Exception;

    T search(ID id)throws Exception;

    boolean update(T dto) throws Exception;

    boolean delete(ID id) throws Exception;

}
