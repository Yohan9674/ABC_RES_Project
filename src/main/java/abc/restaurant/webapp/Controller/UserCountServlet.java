package abc.restaurant.webapp.Controller;


import abc.restaurant.webapp.Util.DatabaseUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userCount")
public class UserCountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String json = "{\"userCount\": 0}";

        try (Connection conn = DatabaseUtil.getConnection(); 
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS count FROM users")) {

            if (rs.next()) {
                int userCount = rs.getInt("count");
                json = "{\"userCount\": " + userCount + "}";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Optionally, handle the error with a different response or logging
        }

        out.print(json);
        out.flush();
    }
}