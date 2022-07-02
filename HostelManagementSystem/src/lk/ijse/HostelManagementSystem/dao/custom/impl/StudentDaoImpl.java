package lk.ijse.HostelManagementSystem.dao.custom.impl;

import lk.ijse.HostelManagementSystem.dao.custom.StudentDao;
import lk.ijse.HostelManagementSystem.dto.StudentDto;
import lk.ijse.HostelManagementSystem.entity.Room;
import lk.ijse.HostelManagementSystem.entity.Student;
import lk.ijse.HostelManagementSystem.entity.User;
import lk.ijse.HostelManagementSystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private Session session;
    private Transaction transaction;

    @Override
    public String generateNewID() throws Exception {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();

        String hql = "FROM Student ORDER BY studentId DESC";
        List<Student> studentList = session.createQuery(hql).list();
        for (Student student: studentList) {
            String  lastId = student.getStudentId();
            return lastId;
        }

        transaction.commit();
        session.close();

        return null;
    }

    @Override
    public List<Student> getAll() throws Exception {
        return null;
    }

    @Override
    public boolean save(Student dto) throws Exception {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        session.save(dto);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public ArrayList<String> searchId() throws Exception {
        ArrayList<String> idList = new ArrayList<>();

        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        String hql = "FROM Student";
        Query query = session.createQuery(hql);
        List<Student> sIdList = query.list();

        for (Student student: sIdList) {
            idList.add(student.getStudentId());
        }

        transaction.commit();
        session.close();

        return idList;
    }

    @Override
    public Student search(String s) throws Exception {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();

        String hql = "FROM Student WHERE studentId =:student_id";
        Query query = session.createQuery(hql);
        query.setParameter("student_id",s);
        List<Student> studentList = query.list();

        for (Student student: studentList) {
            return student;
        }

        transaction.commit();
        session.close();

        return null;
    }

    @Override
    public boolean update(Student dto) throws Exception {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        session.update(dto);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        Student student = session.load(Student.class,s);
        session.delete(student);
        transaction.commit();
        session.close();

        return true;
    }
}
