package abc.restaurant.webapp.Service;

import abc.restaurant.webapp.Dao.UserDao;
import abc.restaurant.webapp.Model.User;

public class UserService {

    public boolean register(User user) throws Exception {
      
        if (UserDao.isUsernameTaken(user.getUsername())) {
            return false;  
        }

       
        UserDao.addUser(user);
        return true;  
    }

   
    public User login(String username, String password) throws Exception {
        User user = UserDao.getUserByUsernameAndPassword(username, password);

        if (user != null && user.getPassword().equals(password)) {
            return user;  
        }

        return null;  
    }
}
