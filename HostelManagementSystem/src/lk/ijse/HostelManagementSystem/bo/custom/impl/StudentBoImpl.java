package lk.ijse.HostelManagementSystem.bo.custom.impl;

import lk.ijse.HostelManagementSystem.bo.BOFactory;
import lk.ijse.HostelManagementSystem.bo.custom.StudentBo;
import lk.ijse.HostelManagementSystem.dao.DaoFactory;
import lk.ijse.HostelManagementSystem.dao.custom.RoomDao;
import lk.ijse.HostelManagementSystem.dao.custom.StudentDao;
import lk.ijse.HostelManagementSystem.dao.custom.impl.StudentDaoImpl;
import lk.ijse.HostelManagementSystem.dao.custom.impl.UserDaoImpl;
import lk.ijse.HostelManagementSystem.dto.StudentDto;
import lk.ijse.HostelManagementSystem.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentBoImpl implements StudentBo{
    StudentDaoImpl studentDaoImpl = (StudentDaoImpl) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.STUDENT);

    @Override
    public ArrayList<StudentDto> getAllStudent() throws Exception {
        return null;
    }

    @Override
    public boolean deleteStudent(String code) throws Exception {
        return studentDaoImpl.delete(code);
    }

    @Override
    public boolean saveStudent(Student dto) throws Exception {
        return studentDaoImpl.save(dto);
    }

    @Override
    public boolean updateStudent(Student dto) throws Exception {
        return studentDaoImpl.update(dto);
    }

    @Override
    public boolean existsStudent(String code) throws Exception {
        return false;
    }

    @Override
    public Student searchStudent(String code) throws Exception {
        return studentDaoImpl.search(code);
    }

    @Override
    public String generateNewStudentId() throws Exception {
        return studentDaoImpl.generateNewID();
    }

    @Override
    public ArrayList<String> searchStudentCode() throws Exception {
        return studentDaoImpl.searchId();
    }
}
