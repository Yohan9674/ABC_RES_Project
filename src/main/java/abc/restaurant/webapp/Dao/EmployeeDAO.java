package abc.restaurant.webapp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import abc.restaurant.webapp.Model.Employee;
import abc.restaurant.webapp.Util.DatabaseUtil;

public class EmployeeDAO {
    public boolean registerEmployee(Employee employee) {
        try {
            Connection conn = DatabaseUtil.getConnection();
            String query = "INSERT INTO employees(name, username, password, role, email, phone) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getUsername());
            ps.setString(3, employee.getPassword());
            ps.setString(4, employee.getRole());
            ps.setString(5, employee.getEmail());
            ps.setString(6, employee.getPhone());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Employee login(String username, String password) {
        try {
            Connection conn = DatabaseUtil.getConnection();
            String query = "SELECT * FROM employees WHERE username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Employee employee = new Employee();
                employee.setUsername(rs.getString("username"));
                employee.setPassword(rs.getString("password"));
                employee.setRole(rs.getString("role"));
                return employee;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}