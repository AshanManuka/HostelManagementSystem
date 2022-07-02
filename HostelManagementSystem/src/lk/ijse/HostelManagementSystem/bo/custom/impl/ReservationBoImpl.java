package lk.ijse.HostelManagementSystem.bo.custom.impl;

import lk.ijse.HostelManagementSystem.bo.BOFactory;
import lk.ijse.HostelManagementSystem.bo.custom.ReservationBo;
import lk.ijse.HostelManagementSystem.dao.DaoFactory;
import lk.ijse.HostelManagementSystem.dao.custom.impl.ReservationDaoImpl;
import lk.ijse.HostelManagementSystem.entity.Reservation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationBoImpl implements ReservationBo {
    ReservationDaoImpl reservationDaoImpl = (ReservationDaoImpl) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.RESERVATION);

    @Override
    public List<Reservation> getAllReservation() throws Exception {
        return reservationDaoImpl.getAll();
    }

    @Override
    public boolean deleteReservation(String code) throws Exception {
        return reservationDaoImpl.delete(code);
    }

    @Override
    public boolean saveReservation(Reservation dto) throws Exception {
        return reservationDaoImpl.save(dto);
    }

    @Override
    public String generateNewId() throws Exception {
        return reservationDaoImpl.generateNewID();
    }
}
