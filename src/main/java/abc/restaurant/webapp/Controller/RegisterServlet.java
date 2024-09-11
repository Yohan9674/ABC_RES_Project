package abc.restaurant.webapp.Controller;

import abc.restaurant.webapp.Model.User;
import abc.restaurant.webapp.Service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String jobRole = request.getParameter("job_role");
        String email = request.getParameter("email");

        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setJobRole(jobRole);
        user.setEmail(email);

        try {
            userService.register(user);
            // Set success message
            request.setAttribute("successMessage", "Registration successful!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            // Set error message
            request.setAttribute("errorMessage", "Registration failed. Please try again.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
