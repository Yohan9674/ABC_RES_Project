package abc.restaurant.webapp.Controller;

import abc.restaurant.webapp.Model.User;
import abc.restaurant.webapp.Service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            User user = userService.login(username, password);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);

                // Check job role and redirect to respective dashboard
                if ("admin".equalsIgnoreCase(user.getJobRole())) {
                    response.sendRedirect("adminDashboard.jsp");
                } else if ("staff".equalsIgnoreCase(user.getJobRole())) {
                    response.sendRedirect("staffDashboard.jsp");
                } else {
                    // In case of an unrecognized role
                    response.sendRedirect("login.jsp");
                }
            } else {
                // If login fails
                request.setAttribute("errorMessage", "Invalid username or password.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Optional error page redirection
        }
    }
}
