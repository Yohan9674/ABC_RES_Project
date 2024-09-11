package abc.restaurant.webapp.Service;

import abc.restaurant.webapp.Dao.QueryDAO;
import abc.restaurant.webapp.Model.Query;

public class QueryService {
    private QueryDAO queryDAO = new QueryDAO();

    public void submitQuery(Query query) throws Exception {
        queryDAO.submitQuery(query);
    }
}