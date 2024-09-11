package abc.restaurant.webapp.Service;

import abc.restaurant.webapp.Dao.PaymentDAO;
import abc.restaurant.webapp.Model.Payment;

public class PaymentService {
    private PaymentDAO paymentDAO = new PaymentDAO();

    public void processPayment(Payment payment) throws Exception {
        // Add validation or business logic if required
        paymentDAO.savePayment(payment);
    }
}