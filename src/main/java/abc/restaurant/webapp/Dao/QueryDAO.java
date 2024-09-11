package abc.restaurant.webapp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import abc.restaurant.webapp.Model.Query;
import abc.restaurant.webapp.Util.DatabaseUtil;

public class QueryDAO {
    public void submitQuery(Query query) throws SQLException {
        String querySQL = "INSERT INTO queries (name, email, message) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(querySQL)) {
            ps.setString(1, query.getName());
            ps.setString(2, query.getEmail());
            ps.setString(3, query.getMessage());
            ps.executeUpdate();
        }
    }
}