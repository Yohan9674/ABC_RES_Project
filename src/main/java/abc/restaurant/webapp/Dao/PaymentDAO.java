package abc.restaurant.webapp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import abc.restaurant.webapp.Model.Payment;
import abc.restaurant.webapp.Util.DatabaseUtil;

public class PaymentDAO {
    public void savePayment(Payment payment) throws SQLException {
        String sql = "INSERT INTO payments (reservation_id, payment_type, card_number, name_on_card, expiry_date, cvc, amount) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseUtil.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, payment.getReservationId());
            ps.setString(2, payment.getPaymentType());
            ps.setString(3, payment.getCardNumber());
            ps.setString(4, payment.getNameOnCard());
            ps.setString(5, payment.getExpiryDate());
            ps.setString(6, payment.getCvc());
            ps.setDouble(7, payment.getAmount());
            ps.executeUpdate();
        }
    }
}