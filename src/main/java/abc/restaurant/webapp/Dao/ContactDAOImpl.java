package abc.restaurant.webapp.Dao;

import abc.restaurant.webapp.Model.Contact;
import abc.restaurant.webapp.Util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactDAOImpl implements ContactDAO {
    private static final String INSERT_CONTACT_SQL = "INSERT INTO contact_us (name, email, subject, message) VALUES (?, ?, ?, ?)";

    @Override
    public void saveContact(Contact contact) {
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTACT_SQL)) {
            
            preparedStatement.setString(1, contact.getName());
            preparedStatement.setString(2, contact.getEmail());
            preparedStatement.setString(3, contact.getSubject());
            preparedStatement.setString(4, contact.getMessage());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Consider logging the exception or rethrowing it based on your use case.
        }
    }
}
