package lk.ijse.HostelManagementSystem.dao;

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
        STUDENT, ROOM, USER
    }

    public SuperDao getDAO(DAOTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentDaoImpl();
            case ROOM:
                return new RoomDaoImpl();
            case USER:
                return new UserDaoImpl();
            default:
                return null;
        }
    }
}
