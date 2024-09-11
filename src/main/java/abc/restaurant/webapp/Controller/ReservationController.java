package abc.restaurant.webapp.Controller;

import abc.restaurant.webapp.Model.Reservation;
import abc.restaurant.webapp.Service.ReservationService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ReservationController extends HttpServlet {
    private ReservationService reservationService = new ReservationService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract reservation details from request
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        int persons = Integer.parseInt(request.getParameter("persons"));
        String message = request.getParameter("message");

        // Create Reservation object
        Reservation reservation = new Reservation();
        reservation.setName(name);
        reservation.setEmail(email);
        reservation.setPhone(phone);
        reservation.setDate(date);
        reservation.setTime(time);
        reservation.setPersons(persons);
        reservation.setMessage(message);

        // Check availability and save if possible
        boolean isAvailable = reservationService.makeReservation(reservation);

        if (isAvailable) {
            request.setAttribute("status", "Reservation confirmed!");
        } else {
            request.setAttribute("status", "Sorry, the date is fully booked. Please try another day.");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("reservation.jsp");
        dispatcher.forward(request, response);
    }
}
