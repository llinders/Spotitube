package dea.luclinders.dataaccess.dao.user;

import dea.luclinders.domain.User;

public interface UserDAO {

    User findByUsernameAndPassword(String username, String password);

}
