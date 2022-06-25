package lk.ijse.HostelManagementSystem.bo.custom.impl;

import lk.ijse.HostelManagementSystem.bo.custom.StudentBo;
import lk.ijse.HostelManagementSystem.dto.StudentDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentBoImpl implements StudentBo{

    @Override
    public ArrayList<StudentDto> getAllStudent() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean deleteStudent(String code) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean saveStudent(StudentDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateStudent(StudentDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean existsStudent(String code) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public StudentDto searchStudent(String code) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewStudentId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> searchStudentCode() throws SQLException, ClassNotFoundException {
        return null;
    }
}
