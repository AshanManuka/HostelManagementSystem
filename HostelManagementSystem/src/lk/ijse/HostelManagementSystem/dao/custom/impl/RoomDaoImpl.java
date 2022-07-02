package lk.ijse.HostelManagementSystem.dao.custom.impl;

import lk.ijse.HostelManagementSystem.dao.custom.RoomDao;
import lk.ijse.HostelManagementSystem.dto.RoomDto;
import lk.ijse.HostelManagementSystem.entity.Reservation;
import lk.ijse.HostelManagementSystem.entity.Room;
import lk.ijse.HostelManagementSystem.entity.Student;
import lk.ijse.HostelManagementSystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl implements RoomDao {
    private Session session;
    private Transaction transaction;


    @Override
    public String generateNewID() throws Exception {
        return null;
    }

    @Override
    public List<Room> getAll() throws Exception {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Room");
        List<Room> list = query.list();
        transaction.commit();
        session.close();

       return list;
    }

    @Override
    public boolean save(Room dto) throws Exception {
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
        String hql = "FROM Room";
        Query query = session.createQuery(hql);
        List<Room> roomList = query.list();

        for (Room room: roomList) {
            idList.add(room.getRoomId());
        }

        transaction.commit();
        session.close();

        return idList;
    }

    @Override
    public Room search(String s) throws Exception {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();

        String hql = "FROM Room WHERE roomId =:room_id";
        Query query = session.createQuery(hql);
        query.setParameter("room_id",s);
        List<Room> roomList = query.list();

        for (Room room: roomList) {
            return room;
        }

        transaction.commit();
        session.close();

        return null;
    }

    @Override
    public boolean update(Room dto) throws Exception {
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
        Room room = session.load(Room.class,s);
        session.delete(room);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean updateQty(int qty) throws Exception {
     /*   int qt;
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        String hql = "FROM Room WHERE roomId =:room_id";
        Query query = session.createQuery(hql);
        query.setParameter("room_id",qty);
        List<Room> roomList = query.list();

        for (Room room: roomList) {
         qt = room.getQty();
         int newQty = qt - 1;
            System.out.println(qt);
            System.out.println(newQty);

           *//* String qryString2 = "update Room r set r.qty=? where r.roomId=?";
            Query query2 = session.createQuery(qryString2);
            query2.setParameter(newQty, code);*//*

        }

        transaction.commit();
        session.close();
        return true;*/
        return true;
    }

    @Override
    public int searchRoomQty(String code) throws Exception {
        int qt;
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        String hql = "FROM Room WHERE roomId =:room_id";
        Query query = session.createQuery(hql);
        query.setParameter("room_id",code);
        List<Room> roomList = query.list();

        for (Room room: roomList) {
            qt = room.getQty();
            int newQty = qt - 1;
            return newQty;
           }

        transaction.commit();
        session.close();
        return 0;
    }
}
