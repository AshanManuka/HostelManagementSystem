package lk.ijse.HostelManagementSystem.dao.custom.impl;

import lk.ijse.HostelManagementSystem.dao.custom.StudentDao;
import lk.ijse.HostelManagementSystem.dto.StudentDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDaoImpl implements StudentDao {
    @Override
    public String exist() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<StudentDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(StudentDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<String> searchId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public StudentDto search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(StudentDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }
}
