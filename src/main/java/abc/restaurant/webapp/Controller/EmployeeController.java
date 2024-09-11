package abc.restaurant.webapp.Controller;

import abc.restaurant.webapp.Service.EmployeeService;
import abc.restaurant.webapp.Model.Employee;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/EmployeeController")  // URL pattern mapping
public class EmployeeController extends HttpServlet {
    private EmployeeService employeeService = new EmployeeService();

    // Handling POST requests (registration, login, etc.)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("register".equals(action)) {
            handleRegistration(request, response);
        } else if ("login".equals(action)) {
            handleLogin(request, response);
        }
    }

    // Handle employee registration
    private void handleRegistration(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        // Basic input validation (you can expand this as needed)
        if (name == null || username == null || password == null || role == null || email == null || phone == null ||
            name.isEmpty() || username.isEmpty() || password.isEmpty() || role.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            request.setAttribute("errorMessage", "All fields are required!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Create Employee object
        Employee employee = new Employee();
        employee.setName(name);
        employee.setUsername(username);
        employee.setPassword(password);  // Consider hashing the password before storing it
        employee.setRole(role);
        employee.setEmail(email);
        employee.setPhone(phone);

        // Register the employee using the service
        boolean isRegistered = employeeService.registerEmployee(employee);
        if (isRegistered) {
            response.sendRedirect(request.getContextPath() + "/login.jsp?message=RegistrationSuccess");
        } else {
            request.setAttribute("errorMessage", "Registration failed. Try again.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
            dispatcher.forward(request, response);
        }
    }

    // Handle employee login
    private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Basic input validation
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            request.setAttribute("errorMessage", "Username and password are required!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Authenticate the employee using the service
        Employee employee = employeeService.login(username, password);  // Consider checking hashed password
        if (employee != null) {
            // Set session attributes
            HttpSession session = request.getSession();
            session.setAttribute("employee", employee);

            // Redirect based on role
            if ("admin".equals(employee.getRole())) {
                response.sendRedirect(request.getContextPath() + "/admin_dashboard.jsp");
            } else if ("staff".equals(employee.getRole())) {
                response.sendRedirect(request.getContextPath() + "/staff_dashboard.jsp");
            }
        } else {
            request.setAttribute("errorMessage", "Invalid username or password.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
}