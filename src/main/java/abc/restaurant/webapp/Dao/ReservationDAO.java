package abc.restaurant.webapp.Dao;

import abc.restaurant.webapp.Model.Reservation;
import abc.restaurant.webapp.Util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationDAO {
    public boolean saveReservation(Reservation reservation) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DatabaseUtil.getConnection();
            String query = "INSERT INTO reservations (name, email, phone, date, time, persons, message) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, reservation.getName());
            pstmt.setString(2, reservation.getEmail());
            pstmt.setString(3, reservation.getPhone());
            pstmt.setString(4, reservation.getDate());
            pstmt.setString(5, reservation.getTime());
            pstmt.setInt(6, reservation.getPersons());
            pstmt.setString(7, reservation.getMessage());

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // New method to get total persons by date
    public int getTotalPersonsByDate(String date) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int totalPersons = 0;

        try {
            conn = DatabaseUtil.getConnection();
            String query = "SELECT SUM(persons) FROM reservations WHERE date = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, date);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                totalPersons = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return totalPersons;
    }
}
