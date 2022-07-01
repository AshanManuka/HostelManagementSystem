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
    public List<Reservation> getAllReservation() throws SQLException, ClassNotFoundException {
        return reservationDaoImpl.getAll();
    }

    @Override
    public boolean deleteReservation(String code) throws SQLException, ClassNotFoundException {
        return reservationDaoImpl.delete(code);
    }

    @Override
    public boolean saveReservation(Reservation dto) throws SQLException, ClassNotFoundException {
        return reservationDaoImpl.save(dto);
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return reservationDaoImpl.generateNewID();
    }
}
