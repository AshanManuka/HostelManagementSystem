package lk.ijse.HostelManagementSystem.dao;

import lk.ijse.HostelManagementSystem.bo.custom.impl.ReservationBoImpl;
import lk.ijse.HostelManagementSystem.dao.custom.impl.ReservationDaoImpl;
import lk.ijse.HostelManagementSystem.dao.custom.impl.RoomDaoImpl;
import lk.ijse.HostelManagementSystem.dao.custom.impl.StudentDaoImpl;
import lk.ijse.HostelManagementSystem.dao.custom.impl.UserDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getDaoFactory() {
        if (daoFactory == null) {
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes {
        STUDENT, ROOM, USER, RESERVATION
    }

    public SuperDao getDAO(DAOTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentDaoImpl();
            case ROOM:
                return new RoomDaoImpl();
            case USER:
                return new UserDaoImpl();
            case RESERVATION:
                return new ReservationDaoImpl();
            default:
                return null;
        }
    }
}
