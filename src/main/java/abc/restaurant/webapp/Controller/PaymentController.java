package abc.restaurant.webapp.Controller;

import abc.restaurant.webapp.Model.Payment;
import abc.restaurant.webapp.Service.PaymentService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/submit-payment")
public class PaymentController extends HttpServlet {
    private PaymentService paymentService = new PaymentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String reservationId = request.getParameter("reservationId");
        String paymentType = request.getParameter("paymentType");
        String cardNumber = request.getParameter("cardNumber");
        String nameOnCard = request.getParameter("nameOnCard");
        String expiryDate = request.getParameter("expiryDate");
        String cvc = request.getParameter("cvc");
        double amount = Double.parseDouble(request.getParameter("amount"));

        Payment payment = new Payment();
        payment.setReservationId(reservationId);
        payment.setPaymentType(paymentType);

        if (paymentType.equals("visa")) {
            payment.setCardNumber(cardNumber);
            payment.setNameOnCard(nameOnCard);
            payment.setExpiryDate(expiryDate);
            payment.setCvc(cvc);
        }
        payment.setAmount(amount);

        try {
            paymentService.processPayment(payment);
            // Redirect back to payment.jsp with success message
            response.sendRedirect("payment.jsp?success=true");
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("payment.jsp").forward(request, response);
        }
    }
}