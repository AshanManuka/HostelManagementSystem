package lk.ijse.HostelManagementSystem.bo.custom;

import lk.ijse.HostelManagementSystem.bo.SuperBo;
import lk.ijse.HostelManagementSystem.dto.StudentDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentBo extends SuperBo {
    ArrayList<StudentDto> getAllStudent() throws SQLException, ClassNotFoundException;

    boolean deleteStudent(String code) throws SQLException, ClassNotFoundException;

    boolean saveStudent(StudentDto dto) throws SQLException, ClassNotFoundException;

    boolean updateStudent(StudentDto dto) throws SQLException, ClassNotFoundException;

    boolean existsStudent(String code) throws SQLException, ClassNotFoundException;

    StudentDto searchStudent(String code) throws SQLException, ClassNotFoundException;

    String generateNewStudentId() throws SQLException, ClassNotFoundException;

    ArrayList<String> searchStudentCode() throws SQLException, ClassNotFoundException;
}
