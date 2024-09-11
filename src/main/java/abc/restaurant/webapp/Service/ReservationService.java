package abc.restaurant.webapp.Service;

import abc.restaurant.webapp.Dao.ReservationDAO;
import abc.restaurant.webapp.Model.Reservation;

public class ReservationService {
    private static final int MAX_PERSONS_PER_DAY = 20;
    private ReservationDAO reservationDAO = new ReservationDAO();

    public boolean isDateAvailable(String date, int requestedPersons) {
        int totalPersons = reservationDAO.getTotalPersonsByDate(date);
        return (totalPersons + requestedPersons) <= MAX_PERSONS_PER_DAY;
    }

    public boolean makeReservation(Reservation reservation) {
        // Check availability first
        if (isDateAvailable(reservation.getDate(), reservation.getPersons())) {
            return reservationDAO.saveReservation(reservation);
        } else {
            return false;  // Date is fully booked
        }
    }
}
