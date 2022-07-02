package lk.ijse.HostelManagementSystem.dao.custom.impl;

import lk.ijse.HostelManagementSystem.dao.custom.ReservationDao;
import lk.ijse.HostelManagementSystem.entity.Reservation;
import lk.ijse.HostelManagementSystem.entity.Room;
import lk.ijse.HostelManagementSystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationDaoImpl implements ReservationDao {
    private Session session;
    private Transaction transaction;


    @Override
    public String generateNewID() throws Exception {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();

        String hql = "FROM Reservation ORDER BY resId DESC";
        List<Reservation> reservationList = session.createQuery(hql).list();
        for (Reservation reservation: reservationList) {
            String  lastId = reservation.getResId();
            return lastId;
        }
        transaction.commit();
        session.close();
        return null;
    }

    @Override
    public List<Reservation> getAll() throws Exception {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Reservation");
        List<Reservation> list = query.list();
        transaction.commit();
        session.close();

        return list;
    }

    @Override
    public boolean save(Reservation dto) throws Exception {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        session.save(dto);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public ArrayList<String> searchId() throws Exception {
        return null;
    }

    @Override
    public Reservation search(String s) throws Exception {
        return null;
    }

    @Override
    public boolean update(Reservation dto) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        Reservation res = session.load(Reservation.class,s);
        session.delete(res);
        transaction.commit();
        session.close();
        return true;
    }
}
