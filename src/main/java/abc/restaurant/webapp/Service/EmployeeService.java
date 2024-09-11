package abc.restaurant.webapp.Service;


import abc.restaurant.webapp.Dao.EmployeeDAO;
import abc.restaurant.webapp.Model.Employee;

public class EmployeeService {
    EmployeeDAO employeeDAO = new EmployeeDAO();

    public boolean registerEmployee(Employee employee) {
        return employeeDAO.registerEmployee(employee);
    }

    public Employee login(String username, String password) {
        return employeeDAO.login(username, password);
    }
}