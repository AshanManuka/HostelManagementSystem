package lk.ijse.HostelManagementSystem.bo;

import lk.ijse.HostelManagementSystem.bo.custom.impl.ReservationBoImpl;
import lk.ijse.HostelManagementSystem.bo.custom.impl.RoomBoImpl;
import lk.ijse.HostelManagementSystem.bo.custom.impl.StudentBoImpl;
import lk.ijse.HostelManagementSystem.bo.custom.impl.UserBoImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBoFactory() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public SuperBo getBO(BOTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentBoImpl();
            case ROOM:
                return new RoomBoImpl();
            case USER:
                return new UserBoImpl();
            case RESERVATION:
                return new ReservationBoImpl();
            default:
                return null;
        }
    }

    public enum BOTypes {
        STUDENT, ROOM, USER, RESERVATION
    }
}
