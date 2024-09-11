package abc.restaurant.webapp.Controller;

import abc.restaurant.webapp.Model.Query;
import abc.restaurant.webapp.Service.QueryService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/submit-query")
public class QueryController extends HttpServlet {
    private QueryService queryService = new QueryService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        Query query = new Query();
        query.setName(name);
        query.setEmail(email);
        query.setMessage(message);

        try {
            queryService.submitQuery(query);
            response.sendRedirect("query-success.jsp");
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("submit-query.jsp").forward(request, response);
        }
    }
}