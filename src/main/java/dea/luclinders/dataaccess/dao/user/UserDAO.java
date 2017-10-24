package dea.luclinders.dataaccess.dao.user;

import dea.luclinders.dataaccess.dao.DAO;
import dea.luclinders.domain.User;

public interface UserDAO extends DAO<User> {

    User findByUsernameAndPassword(String username, String password);

}
