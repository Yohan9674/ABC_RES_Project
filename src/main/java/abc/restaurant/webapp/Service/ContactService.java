package abc.restaurant.webapp.Service;

import abc.restaurant.webapp.Dao.ContactDAO;
import abc.restaurant.webapp.Dao.ContactDAOImpl;
import abc.restaurant.webapp.Model.Contact;

public class ContactService {
    private final ContactDAO contactDAO;

    public ContactService() {
        this.contactDAO = new ContactDAOImpl();
    }

    public void saveContact(Contact contact) {
        // Additional business logic can go here if needed
        contactDAO.saveContact(contact);
    }
}
